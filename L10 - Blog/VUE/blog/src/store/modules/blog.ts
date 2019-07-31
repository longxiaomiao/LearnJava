import ListState from './list-state';
import Blog from '../entities/blog';
import ListMutations from './list-mutations';
import ListModule from './list-module';
import { ActionContext } from 'vuex';
import Ajax from '../../lib/ajax';
import PageResult from '../entities/page-result';

interface BlogState extends ListState<Blog> {
    keyWord: string;
    showList: boolean;
    showDetail: boolean;
    blogDetail: Blog;
    currentCategoryId: string;
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
        showList: true,
        showDetail: false,
        blogDetail: new Blog(),
        currentCategoryId: '',
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
        async getDetail(context: ActionContext<BlogState, any>, payload: any) {
            context.state.loading = true;
            const reponse = await Ajax.get('/Blog/GetById', { params: payload.data });
            context.state.loading = false;
            const blogDetail = reponse.data as Blog;
            context.state.blogDetail = blogDetail;
        },
    };
    public mutations = {
        setShowList(state: BlogState, showList: boolean) {
            state.showList = showList;
        },
        setShowDetail(state: BlogState, showDetail: boolean) {
            state.showDetail = showDetail;
        },
        setCurrentCategoryId(state: BlogState, categoryId: string) {
            state.currentCategoryId = categoryId;
        },
        setKeyWord(state: BlogState, keyWord: string) {
            state.keyWord = keyWord;
        },
    };
}

const blogModule = new BlogModule();
export default blogModule;
