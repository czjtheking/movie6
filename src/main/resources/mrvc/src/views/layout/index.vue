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
import store from "@/store";

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
          moviePicURL: require("@/assets/a.jpg"),
          movieName: "阿甘正传",
          movieId: 3,
        },
        {
          moviePicURL: require("@/assets/da.jpg"),
          movieName: "霸王别姬",
          movieId: 2,
        },
        {
          moviePicURL: require("@/assets/shao.jpg"),
          movieName: "肖申克的救赎",
          movieId: 1,
        },
        {
          moviePicURL: require("@/assets/tai.jpg"),
          movieName: "泰坦尼克号",
          movieId: 4,
        },
        {
          moviePicURL: require("@/assets/sha.jpg"),
          movieName: "这个杀手不太冷",
          movieId: 5,
        },
      ], //轮播图
      popList: [], //热门
      recomList: [], //推荐
    };
  },
  async created() {
    this.$store.commit("info/setInfoMark", 1);
    const res = await getHomeData(Number(store.getters.getUserId));
    console.log(res);
    // this.bannerList = res.data.slice(0, 5); //接收三个数组存入数据
    this.popList = res.data.slice(5, 9);
    this.recomList = res.data.slice(9);
  },
};
</script>

<style scoped lang="less">
</style>