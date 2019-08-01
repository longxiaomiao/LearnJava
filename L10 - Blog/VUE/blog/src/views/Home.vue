<template>
  <div class="main">
    <b-navbar toggleable="lg" type="dark" variant="info">
      <div class="container">
        <b-navbar-brand href="/">sea</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-form>
              <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="keyWord"></b-form-input>
              <b-button
                size="sm"
                class="my-2 my-sm-0"
                variant="primary"
                @click="searchBlog(currentCategoryId)"
              >Search</b-button>
            </b-nav-form>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-navbar-nav>
              <b-nav-item href="/about" target="_blank">About</b-nav-item>
            </b-navbar-nav>
          </b-navbar-nav>
        </b-collapse>
      </div>
    </b-navbar>

    <b-jumbotron>
      <div class="container">
        <h1>{{siteConfig.title}}</h1>
        <p>{{siteConfig.info}}</p>
      </div>
    </b-jumbotron>
    <div class="content px-4">
      <div class="container">
        <div class="container">
          <div class="row">
            <div class="col-sm-8">
              <Blogs ref="childBlogList" v-if="showList"></Blogs>
              <BlogDetail v-if="showDetail"></BlogDetail>
            </div>
            <div class="col-sm-4">
              <div class="container">
                <div class="row">
                  <div class="col">
                    <div class="card">
                      <img :src="siteConfig.photo" class="card-img-top" />
                      <div class="card-body">
                        <h5 class="card-title">{{siteConfig.userName}}</h5>
                        <p class="card-text">{{siteConfig.userInfo}}</p>
                        <a
                          :href="siteConfig.gitHub"
                          v-show="siteConfig.gitHub!=''"
                          class="btn btn-outline-info"
                          target="_blank"
                        >Fork Me On GitHub</a>
                      </div>
                    </div>
                  </div>
                  <div class="w-100" style="height:10px"></div>
                  <div class="col">
                    <b-list-group>
                      <b-list-group-item
                        href="javascript:void(0);"
                        v-for="category in categoryList"
                        @click="searchBlog(category.id)"
                        :active="currentCategoryId==category.id"
                      >{{category.name}}</b-list-group-item>
                    </b-list-group>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang='ts'>
import { Component, Vue } from "vue-property-decorator";
import Blogs from "@/components/Blogs.vue";
import BlogDetail from "@/components/BlogDetail.vue";

@Component({
  components: { Blogs, BlogDetail }
})
export default class Home extends Vue {
  $refs!: { childBlogList: HTMLFormElement };
  public keyWord: string = "";

  get showList() {
    return this.$store.state.Blog.showList;
  }

  get showDetail() {
    return this.$store.state.Blog.showDetail;
  }

  get currentCategoryId() {
    return this.$store.state.Blog.currentCategoryId;
  }

  get categoryList() {
    return this.$store.state.Category.list;
  }

  get siteConfig() {
    return this.$store.state.SiteConfig.siteConfigInfo;
  }

  public async searchBlog(categoryId: string = "") {
    this.$store.commit("Blog/setCurrentCategoryId", categoryId);
    this.$store.commit("Blog/setKeyWord", this.keyWord);
    this.$refs.childBlogList.getBlogs();
  }

  public async created() {
    await this.$store.dispatch("Category/getAll");
    await this.$store.dispatch("getSiteConfig");
  }
}
</script>
