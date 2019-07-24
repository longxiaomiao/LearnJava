import ListState from './list-state';

export default class ListMutations<T> {
    public setCurrentPage(state: ListState<T>, page: number) {
        state.start = page;
    }
    public setPageSize(state: ListState<T>, pagesize: number) {
        state.size = pagesize;
    }
}
