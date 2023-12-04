<template>
  <div class="search-index">
    <div class="top"></div>
    <div class="title">搜索结果</div>
    <div class="main">
      <ul
        class="infinite-list"
        style="overflow: auto"
        infinite-scroll-delay="2000"
      >
        <li
          v-for="(item, index) in searchList"
          :key="index"
          class="infinite-list-item smovie"
        >
          <PopularMovie :movie="item"> </PopularMovie>
        </li>
      </ul>
    </div>
    <el-backtop :bottom="100" :right="20">
      <div
        class=".goTO"
        style="
           {
            height: 100%;
            width: 100%;
            background-color: #f2f5f6;
            box-shadow: 0 0 6px rgba(0, 0, 0, 0.12);
            text-align: center;
            line-height: 40px;
            color: #1989fa;
          }
        "
      >
        顶部
      </div>
    </el-backtop>
  </div>
</template>

<script>
import PopularMovie from "@/components/PopularMovie";

import { getSearchData } from "@/api/search";

export default {
  name: "SearchIndex",
  data() {
    return {
      page: 1,
      searchList: [
        //这里设置默认后面改
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          genre: "类别",
          movie_intro:
            "这是一段电影简介这是一段电影简介这是一段电影简介这是一段电影简介这是一段电影简介这是一段电影简介这是一段电影简介",
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          genre: "类别",
          movie_intro: "这是一段电影简介",
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          genre: "类别",
          movie_intro: "这是一段电影简介",
        },
      ],
    };
  },
  methods: {
    // load() {
    //   this.searchList.push({
    //     img: require("@/assets/test2.jpg"),
    //     movie_name: "电影名",
    //     actor: "主演",
    //     genre: "类别",
    //     movie_intro: "这是一段电影简介",
    //   });
    // },
  },
  components: {
    PopularMovie,
  },
  computed: {
    querySearch() {
      return this.$route.query.searchWords;
    },
  },
  async created() {
    const res = await getSearchData({
      search_words: this.querySearch,
    });
    this.searchList = res.data; //获取后台数据
    console.log(res);
  },
};
</script>

<style scoped lang="less">
.search-index {
  width: 99vw;
  // background-color: pink;
  .top {
    height: 68px;
  }
  .title {
    height: 80px;
    width: 90vw;
    // background-color: green;
    font-size: 40px;

    margin: 0 auto;
  }
  .main {
    // height: 2300px;
    width: 90vw;
    // background-color: yellow;

    margin: 0 auto;
  }
}
</style>