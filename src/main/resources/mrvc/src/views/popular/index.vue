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
      ],
    };
  },
  components: {
    PopularMovie,
  },
  async created() {
    this.$store.commit("info/setInfoMark", 1);
    const res = await getPopData();

    this.popList = res.data; //获取后台数据
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
    color: #2e2c2c;
    font-weight: 800;
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