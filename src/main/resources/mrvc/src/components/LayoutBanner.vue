<template>
  <div class="layout-banner">
    <div class="top"></div>
    <!-- <div class="pic"></div> -->
    <div class="banner">
      <el-carousel :interval="4000" type="card" height="380px">
        <el-carousel-item v-for="(item, index) in list" :key="index">
          <img
            :src="item.moviePicURL"
            alt=""
            class="main-pic"
            width="100%"
            height="100%"
            referrerpolicy="no-referrer"
            @click="handleDetails(item.movieId)"
          />
          <span class="title">{{ item.movieName }}</span>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
export default {
  name: "LayoutBanner",
  data() {
    return {};
  },
  props: ["list"],
  methods: {
    handleDetails(id) {
      console.log(id);
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
.layout-banner {
  height: 450px;
  width: 99vw;
  // background-color: rgb(245, 129, 148);

  .top {
    height: 68px;
  }
  .pic {
    height: 150px;
    width: 99vw;

    background: url("@/assets/test.png") repeat-x top left/100%;
    /* 背景色 背景图 平铺方式 背景图位置/背景图大小 */
  }
  .banner {
    height: 382px;
    width: 85vw;
    // background-color: rgb(158, 160, 154);

    margin: 0 auto;
    margin-top: 20px;
    position: relative;
    .main-pic {
      position: absolute;
      z-index: -1;
    }
    .title {
      position: relative;
      bottom: -300px;
      right: -20px;
      font-size: 30px;
    }
    .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n + 1) {
      background-color: #d3dce6;
    }
  }
}

@media (max-width: 1200px) and (min-width: 600px) {
  .layout-banner {
    width: 1183px;
    .top {
      width: 1200px;
    }
    .pic {
      width: 1200px;
    }
    .banner {
      width: 1080px;
    }
  }
}
@media (max-width: 600px) {
  .layout-banner {
    display: none;
  }
}
</style>