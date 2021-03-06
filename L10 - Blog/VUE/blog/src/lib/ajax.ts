import axios from 'axios';
import appconst from './appconst';
import Vue from 'vue';
const ajax = axios.create({
    baseURL: appconst.remoteServiceBaseUrl,
    timeout: 30000,
});
// tslint:disable-next-line: only-arrow-functions
ajax.interceptors.request.use(function(config) {
    return config;
// tslint:disable-next-line: only-arrow-functions
}, function(error) {

    return Promise.reject(error);
});
const vm = new Vue({});
ajax.interceptors.response.use((respon) => {
    return respon;
}, (error) => {
    // tslint:disable-next-line: max-line-length
    if (!!error.response && !!error.response.data.error && !!error.response.data.error.message && error.response.data.error.details) {
        alert('error');
    } else if (!!error.response && !!error.response.data.error && !!error.response.data.error.message) {
        alert('error');
    } else if (!error.response) {
        alert('error');
    }
    return Promise.reject(error);
});
export default ajax;
