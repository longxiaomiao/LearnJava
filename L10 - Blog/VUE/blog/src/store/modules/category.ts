import ListState from './list-state';
import Category from '../entities/category';
import ListMutations from './list-mutations';
import ListModule from './list-module';
import { ActionContext } from 'vuex';
import Ajax from '../../lib/ajax';
import PageResult from '../entities/page-result';

interface CategoryState extends ListState<Category> {
    keyWord: string;
}

class CategoryMutations extends ListMutations<Category> {

}

// tslint:disable-next-line: max-classes-per-file
class CategoryModule extends ListModule<CategoryState, any, Category> {
    public state = {
        keyWord: '',
        total: 0,
        start: 0,
        size: 5,
        list: new Array<Category>(),
        loading: false,
    };
    public actions = {
        async getAll(context: ActionContext<CategoryState, any>) {
            context.state.loading = true;
            const reponse = await Ajax.get('/Category');
            context.state.loading = false;
            const page = reponse.data as PageResult<Category>;
            context.state.list = page.list;
        },
    };
}

const categoryModule = new CategoryModule();
export default categoryModule;
