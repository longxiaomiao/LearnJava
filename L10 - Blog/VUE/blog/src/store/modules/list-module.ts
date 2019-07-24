import ListState from './list-state';
import { Module } from 'vuex';

export default class ListModule<T extends ListState<U>, R, U> implements Module<ListState<U>, R> {
    public namespaced = true;
    public state = {
        total: 0,
        start: 0,
        size: 5,
        list: new Array<U>(),
        loading: false,
    };
    public mutations = {
        setCurrentPage(state: ListState<U>, page: number) {
            state.start = page;
        },
        setPageSize(state: ListState<U>, pagesize: number) {
            state.size = pagesize;
        },
    };
}
