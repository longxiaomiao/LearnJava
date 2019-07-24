<template>
  <div class="main">
        <b-navbar toggleable="lg" type="dark" variant="info">
            <div class="container">
                <b-navbar-brand href="/">sea</b-navbar-brand>

                <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

                <b-collapse id="nav-collapse" is-nav>
                    <b-navbar-nav>
                        <b-nav-form>
                            <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="keyword"></b-form-input>
                            <b-button size="sm" class="my-2 my-sm-0" variant="primary" @click="searchBlog(currentCategoryId)">Search</b-button>
                        </b-nav-form>
                    </b-navbar-nav>

                    <!-- Right aligned nav items -->
                    <b-navbar-nav class="ml-auto">
                        <b-navbar-nav>
                            <!-- <b-nav-item :href="siteConfig.about" target="_blank">About</b-nav-item> -->
                            about
                        </b-navbar-nav>
                    </b-navbar-nav>
                </b-collapse>
            </div>
        </b-navbar>

        <b-jumbotron>
            <div class="container">
                <h1>title</h1>
                <p>into</p>
            </div>
        </b-jumbotron>
        <div class="content px-4">
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8">
                            <Blogs></Blogs>
                        </div>
                        <div class="col-sm-4">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <div class="card">
                                            <img src="../assets/logo.png" class="card-img-top">
                                            <div class="card-body">
                                                <h5 class="card-title">sea</h5>
                                                <p class="card-text">sea</p>
                                                <!-- <a :href="siteConfig.gitHub" v-show="siteConfig.gitHub!=''" class="btn btn-outline-info" target="_blank">Fork Me On GitHub</a> -->
                                                谐星
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w-100" style="height:10px"></div>
                                    <div class="col">
                                        <b-list-group>
                                            <!-- <b-list-group-item href="javascript:void(0);" v-for="category in categoryList" @click="searchBlog(category.id)" :active="currentCategoryId==category.id">{{category.name}}</b-list-group-item> -->
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

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Blogs from '@/components/Blogs.vue';

@Component({
  components: {
    Blogs,
  },
})
export default class Home extends Vue {}
</script>
