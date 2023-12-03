<template>
  <div class="layout-recom">
    <div class="popular">
      <div class="poptitle" @click="goToPop">热门电影</div>
      <div class="popmovie">
        <div class="smovie" v-for="(item, index) in poplist" :key="index">
          <SingleMovie :movie="item"></SingleMovie>
        </div>
      </div>
    </div>
    <div class="recom">
      <div class="recomtitle" @click="goToRecom">个性推荐</div>
      <div class="recommovie">
        <div class="smovie" v-for="(item, index) in recomlist" :key="index">
          <SingleMovie :movie="item"></SingleMovie>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SingleMovie from "@/components/SingleMovie";

export default {
  name: "LayoutRecom",
  components: {
    SingleMovie,
  },
  props: ["poplist", "recomlist"],
  methods: {
    goToPop() {
      this.$router.push({
        path: "/popular",
      });
    },
    goToRecom() {
      this.$router.push({
        path: "/recom",
      });
    },
  },
};
</script>

<style scoped lang="less">
.layout-recom {
  height: 1000px;
  width: 80vw;
  // background-color: yellow;

  margin: 0 auto;
  margin-top: 50px;

  .popular {
    .poptitle {
      background-color: #fff;
      border-radius: 10px;
      width: 80vw;
      height: 50px;
      // background-color: gray;
      font-size: 22px;
      color: #44484e;
      font-weight: 600;
      line-height: 50px;
      padding-left: 20px;
      transition: 0.2s;
    }
    .poptitle:hover {
      background-color: #f8f6f6;
      cursor: pointer;
    }
    .popmovie {
      background-color: #fff;
      border-radius: 10px;
      margin-top: 5px;
      width: 80vw;
      height: 420px;
      // background-color: goldenrod;

      display: flex;
      justify-content: space-evenly;
      align-items: center;
    }
    .popbottom {
      width: 80vw;
      height: 20px;
      // background-color: gray;

      text-align: right;
      a {
        text-decoration: none;
        color: rgb(34, 33, 33);
      }
    }
  }

  .recom {
    margin-top: 20px;

    .recomtitle {
      background-color: #fff;
      border-radius: 10px;
      width: 80vw;
      height: 50px;
      // background-color: gray;
      font-size: 22px;
      color: #44484e;
      font-weight: 600;
      line-height: 50px;
      transition: 0.2s;
      padding-left: 20px;
    }
    .recomtitle:hover {
      background-color: #f8f6f6;
      cursor: pointer;
    }
    .recommovie {
      background-color: #fff;
      border-radius: 10px;
      margin-top: 5px;
      width: 80vw;
      height: 420px;
      // background-color: goldenrod;

      display: flex;
      justify-content: space-evenly;
      align-items: center;
    }
    .recombottom {
      width: 80vw;
      height: 20px;
      // background-color: gray;

      text-align: right;
      a {
        text-decoration: none;
        color: rgb(34, 33, 33);
      }
    }
  }
}

@media (max-width: 1200px) and (min-width: 600px) {
  .layout-recom {
    width: 1080px;

    margin: 0 51.5px;
  }
}
</style>