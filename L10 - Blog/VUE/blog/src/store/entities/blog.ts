import Entity from './entity';

export default class Blog extends Entity<string> {
    public slug!: string;
    public title!: string;
    public summary!: string;
    public content!: string;
    public htmlContent!: string;
    public isShow!: boolean;
    public creationTime!: Date;
}
