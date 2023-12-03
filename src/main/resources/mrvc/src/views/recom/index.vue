<template>
  <div class="recom-index">
    <div class="top"></div>
    <div class="title">个性推荐</div>
    <div class="main">
      <ul
        class="infinite-list"
        style="overflow: auto"
        infinite-scroll-delay="2000"
      >
        <li
          v-for="(item, index) in recomList"
          :key="index"
          class="infinite-list-item smovie"
        >
          <PopularMovie :movie="item"> </PopularMovie>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import PopularMovie from "@/components/PopularMovie";

import store from "@/store";

import { getRecomData } from "@/api/search";

export default {
  name: "RecomIndex",
  data() {
    return {
      recomList: [
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
  components: {
    PopularMovie,
  },
  async created() {
    const res = await getRecomData(store.getters.getUserId);

    this.recomList = res.data.recomList; //获取后台数据
    console.log(res);
  },
};
</script>

<style scoped lang="less">
.recom-index {
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
    // height: 1100px;
    width: 90vw;
    // background-color: yellow;

    margin: 0 auto;
    .smovie {
      margin-bottom: 20px;
    }
  }
}
</style>