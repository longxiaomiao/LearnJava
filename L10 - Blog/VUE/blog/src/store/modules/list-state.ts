export default interface ListState<T> {
    total: number;
    start: number;
    size: number;
    list: T[];
    loading: boolean;
}
