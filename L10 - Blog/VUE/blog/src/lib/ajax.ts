import axios from 'axios';
import appconst from './appconst';
import Vue from 'vue';
const ajax = axios.create({
    baseURL: appconst.remoteServiceBaseUrl,
    timeout: 30000,
});
ajax.interceptors.request.use(function (config) {
    return config;
}, function (error) {

    return Promise.reject(error);
});
let vm = new Vue({});
ajax.interceptors.response.use((respon) => {
    return respon
}, (error) => {
    console.log(error);
    if (!!error.response && !!error.response.data.error && !!error.response.data.error.message && error.response.data.error.details) {
        alert('error');
    } else if (!!error.response && !!error.response.data.error && !!error.response.data.error.message) {
        alert('error');
    } else if (!error.response) {
        alert('error');
    }
    return Promise.reject(error);
})
export default ajax;
