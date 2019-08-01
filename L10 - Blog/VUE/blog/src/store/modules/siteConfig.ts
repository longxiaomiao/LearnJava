import SiteConfig from '../entities/siteConfig';
import { Module, ActionContext } from 'vuex';
import ajax from '@/lib/ajax';

interface SiteConfigState {
    siteConfigInfo: SiteConfig;
}

class SiteConfigModule implements Module<SiteConfigState, any> {
    public state = {
        siteConfigInfo: new SiteConfig(),
    };
    public actions = {
        async getSiteConfig(context: ActionContext<SiteConfigState, any>) {
            const response = await ajax.get('/SiteConfig');
            context.state.siteConfigInfo = response.data;
        },
    };
}

const siteConfigModule = new SiteConfigModule();
export default siteConfigModule;
