<template>
  <div class="recom-index">
    <div class="top"></div>
    <div class="title">个性推荐</div>
    <div class="main">
      <div
        class="box"
        v-for="(item, index) in recomList"
        :key="index"
        @click="handleDetails(item.movieId)"
      >
        <img :src="item.moviePicURL" alt="" />
        <span>{{ item.movieName }}</span>
      </div>

      <!-- <ul
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
      </ul> -->
    </div>
  </div>
</template>

<script>
// import PopularMovie from "@/components/PopularMovie";

import store from "@/store";

import { getRecomData } from "@/api/search";

export default {
  name: "RecomIndex",
  data() {
    return {
      recomList: [
        //这里设置默认后面改
        {
          movieId: 1,
          movieName: "电影名",
          movieGenre: 1,
          movieDirector: 1,
          movieActor: 1,
          movieIntro: 1,
          moviePicURL: 1,
          movieRate: 1,
        },
        {
          movieId: 1,
          movieName: 1,
          movieGenre: 1,
          movieDirector: 1,
          movieActor: 1,
          movieIntro: 1,
          moviePicURL: 1,
          movieRate: 1,
        },
        {
          movieId: 1,
          movieName: 1,
          movieGenre: 1,
          movieDirector: 1,
          movieActor: 1,
          movieIntro: 1,
          moviePicURL: 1,
          movieRate: 1,
        },
        {
          movieId: 1,
          movieName: 1,
          movieGenre: 1,
          movieDirector: 1,
          movieActor: 1,
          movieIntro: 1,
          moviePicURL: 1,
          movieRate: 1,
        },
      ],
    };
  },
  components: {
    // PopularMovie,
  },
  async created() {
    this.$store.commit("info/setInfoMark", 1);
    const res = await getRecomData(store.getters.getUserId);

    this.recomList = res.data; //获取后台数据
    console.log(res);
  },
  methods: {
    handleDetails(id) {
      this.$router.push(
        {
          path: "/moviedetails",
          query: {
            id: id,
          },
        },
        () => {},
        () => {}
      );
    },
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
    color: #2e2c2c;
    font-weight: 800;
    margin: 0 auto;
  }
  .main {
    // height: 1100px;
    width: 70vw;
    // background-color: yellow;
    margin: 60px auto;
    height: 600px;
    display: flex;
    .box {
      flex: 1;
      overflow: hidden;
      transition: 0.5s;
      margin: 0 20px;
      box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5);
      border-radius: 20px;
      border: 10px solid #fff;
      background-color: #fff;
    }

    .box > img {
      width: 200%;
      height: 85%;
      object-fit: cover;
      transition: 0.5s;
    }

    .box > span {
      font-weight: 800;
      font-size: 35px;
      font-family: "宋体";
      text-align: center;
      height: 15%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .box:hover {
      flex-basis: 20%;
      cursor: pointer;
    }

    .box:hover > img {
      width: 100%;
      height: 100%;
    }
  }
}
</style>