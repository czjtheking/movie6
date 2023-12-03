<template>
  <div class="information-index">
    <div class="top"></div>
    <div class="main">
      <div class="left">
        <div class="option to-big" @click="toBig(1)" ref="opt1">
          <router-link to="/infor">个人信息</router-link>
        </div>
        <div class="option" @click="toBig(2)" ref="opt2">
          <router-link to="/store">我的收藏</router-link>
        </div>
        <div class="option" v-if="isAdmin" @click="toBig(3)" ref="opt3">
          <router-link to="/add">添加电影</router-link>
        </div>
      </div>
      <div class="right">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import store from "@/store";

export default {
  name: "InformationIndex",
  data() {
    return {
      isAdmin: false,
    };
  },
  created() {
    this.isAdmin = store.getters.getAuth;
  },
  methods: {
    toBig(id) {
      if (id === 1) {
        this.$refs.opt2.classList.remove("to-big");
        this.$refs.opt3.classList.remove("to-big");
        this.$refs.opt1.classList.add("to-big");
      } else if (id === 2) {
        this.$refs.opt1.classList.remove("to-big");
        this.$refs.opt3.classList.remove("to-big");
        this.$refs.opt2.classList.add("to-big");
      } else {
        this.$refs.opt2.classList.remove("to-big");
        this.$refs.opt1.classList.remove("to-big");
        this.$refs.opt3.classList.add("to-big");
      }
    },
  },
};
</script>

<style scoped lang="less">
.information-index {
  width: 99vw;
  height: 950px;
  // background-color: pink;
  .top {
    height: 68px;
  }
  .main {
    width: 75vw;
    height: 800px;
    // background-color: green;
    margin: 50px auto;
    border: 1px solid rgb(204, 203, 203);
    border-radius: 20px;

    display: flex;
    .left {
      width: 15vw;
      height: 798px;
      background-color: #f7f8f8;
      border-radius: 20px 0 0 20px;
      border-right: 1px solid rgb(204, 203, 203);

      display: flex;
      flex-direction: column;
      align-content: center;

      .option {
        height: 60px;
        width: 15vw;
        background-color: #ced6d8;
        border-radius: 20px 0 0 20px;
        font-size: 26px;
        font-weight: 600;

        margin-bottom: 30px;
        display: flex;
        align-items: center;
        justify-content: center;
        transition: 0.3s;

        margin-left: 220px;
        a {
          height: 80px;
          width: 15vw;
          line-height: 80px;
          text-align: center;
          text-decoration: none;
          color: rgb(255, 255, 255);
        }
      }
      .option:hover {
        height: 75px;
        margin-left: 0px;
        background-color: #409eff;
      }
      .to-big {
        height: 75px;
        margin-left: 0;
        background-color: #409eff;
      }
    }
    .right {
      width: 60vw;
      height: 798px;

      background-color: white;
      border-radius: 0 20px 20px 0;
    }
  }
}
</style>