<template>
  <div class="popular-index">
    <div class="top"></div>
    <div class="title">电影热门榜单</div>
    <div class="main">
      <ul
        class="infinite-list"
        style="overflow: auto"
        infinite-scroll-delay="2000"
      >
        <li
          v-for="(item, index) in popList"
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

import { getPopData } from "@/api/search";

export default {
  name: "PopularIndex",
  data() {
    return {
      popList: [
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
    const res = await getPopData();

    this.popList = res.data.popList; //获取后台数据
    console.log(res);
  },
};
</script>

<style scoped lang="less">
.popular-index {
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
    height: 2600px;
    width: 80vw;
    // background-color: yellow;

    margin: 0 auto;
    .smovie {
      margin-bottom: 5px;
    }
  }
}
</style>