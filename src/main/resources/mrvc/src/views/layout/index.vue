<template>
  <div class="layout-index">
    <LayoutBanner :list="bannerList"> </LayoutBanner>
    <LayoutRecom :poplist="popList" :recomlist="recomList"> </LayoutRecom>
  </div>
</template>

<script>
import LayoutBanner from "@/components/LayoutBanner";
import LayoutRecom from "@/components/LayoutRecom";

import { getHomeData } from "@/api/layout";

export default {
  name: "LayoutIndex",
  components: {
    LayoutBanner,
    LayoutRecom,
  },
  data() {
    return {
      bannerList: [
        //这里先设置默认
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
        {
          moviePicURL: require("@/assets/test.png"),
          movieName: "电影名",
          movieId: 111,
        },
      ], //轮播图1
      popList: [
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 121,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 122,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 123,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 124,
        },
      ], //热门
      recomList: [
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 121,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 122,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 123,
        },
        {
          img: require("@/assets/test2.jpg"),
          movie_name: "电影名",
          actor: "主演",
          movie_id: 124,
        },
      ], //推荐
    };
  },
  async created() {
    const res = await getHomeData();
    console.log(res);
    this.bannerList = res.data.slice(0, 5); //接收三个数组存入数据
    this.popList = res.data.slice(5, 9);
    this.recomList = res.data.slice(9);
  },
};
</script>

<style scoped lang="less">
</style>