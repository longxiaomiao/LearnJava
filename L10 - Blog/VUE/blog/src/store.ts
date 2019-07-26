import Vue from 'vue';
import Vuex from 'vuex';
import Blog from './store/modules/blog';
import Category from './store/modules/category';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {

  },
  mutations: {

  },
  actions: {

  },
  modules: {
    Blog,
    Category,
  },
});
