import Entity from './entity';

export default class SiteConfig extends Entity<string> {
    public title!: string;
    public info!: string;
    public photo!: string;
    public userName!: string;
    public userInfo!: string;
    public gitHub!: string;
}
