<template>
  <div>
    <div class="card" style="margin-bottom:10px" v-for="blog in blogList">
      <h5 class="card-header">{{blog.creationTime}}</h5>
      <div class="card-body">
        <h5 class="card-title">
          <a href="javascript:void(0);" @click="showBlogDetail(blog.id)">{{blog.title}}</a>
        </h5>
        <p class="card-text">{{blog.summary}}</p>
        <span
          class="badge badge-pill badge-info"
          v-for="categoryItem in blog.blogCategories"
        >{{categoryItem.category.name}}</span>
      </div>
    </div>
    <b-pagination v-model="currentPage" :total-rows="totalCount" :per-page="pageSize"></b-pagination>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Inject, Prop, Watch } from "vue-property-decorator";
import PageRequest from "../store/entities/page-request";

class PageBlogReqeust extends PageRequest {
  public keyword!: string;
  public categoryId!: string;
}

class BlogDetailRequest {
  public id!: string;
}

@Component
export default class Blogs extends Vue {
  public pageBlogReqeust: PageBlogReqeust = new PageBlogReqeust();
  public blogDetailRequest: BlogDetailRequest = new BlogDetailRequest();

  get blogList() {
    return this.$store.state.Blog.list;
  }

  get loading() {
    return this.$store.state.Blog.loading;
  }

  get currentPage() {
    return this.$store.state.Blog.start;
  }

  set currentPage(value: number) {
    this.$store.state.Blog.start = value;
    this.getBlogs();
  }

  get totalCount() {
    return this.$store.state.Blog.total;
  }

  get pageSize() {
    return this.$store.state.Blog.size;
  }

  public async getBlogs() {
    this.pageBlogReqeust.start = this.currentPage;
    this.pageBlogReqeust.size = this.pageSize;
    this.pageBlogReqeust.keyword = this.$store.state.Blog.keyWord;
    this.pageBlogReqeust.categoryId = this.$store.state.Blog.currentCategoryId;

    await this.$store.dispatch({
      type: "Blog/getPage",
      data: this.pageBlogReqeust
    });
  }

  public async showBlogDetail(id: string) {
    this.$store.commit("Blog/setShowList", false);
    this.$store.commit("Blog/setShowDetail", true);
    this.blogDetailRequest.id = id;
    await this.$store.dispatch({
      type: "Blog/getDetail",
      data: this.blogDetailRequest,
    });
  }

  public async created() {
    this.getBlogs();
  }
}
</script>

<style scoped>
</style>
