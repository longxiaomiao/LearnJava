import ListState from './list-state';
import Blog from '../entities/blog';
import ListMutations from './list-mutations';
import ListModule from './list-module';
import { ActionContext } from 'vuex';
import Ajax from '../../lib/ajax';
import PageResult from '../entities/page-result';

interface BlogState extends ListState<Blog> {
    keyWord: string;
}

class BlogMutations extends ListMutations<Blog> {

}

// tslint:disable-next-line: max-classes-per-file
class BlogModule extends ListModule<BlogState, any, Blog> {
    public state = {
        keyWord: '',
        total: 0,
        start: 0,
        size: 5,
        list: new Array<Blog>(),
        loading: false,
    };
    public actions = {
        async getPage(context: ActionContext<BlogState, any>, payload: any) {
            context.state.loading = true;
            const reponse = await Ajax.get('/Blog', { params: payload.data });
            context.state.loading = false;
            const page = reponse.data as PageResult<Blog>;
            context.state.total = page.total;
            context.state.list = page.list;
        },
    };
}

const blogModule = new BlogModule();
export default blogModule;
