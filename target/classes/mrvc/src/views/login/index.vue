<template>
  <div class="login-index">
    <div class="top"></div>
    <div class="main">
      <div class="left">
        <div class="welcome-title">
          <!-- <h1 class="welcome">欢迎登陆</h1>
          <p class="title">个性化电影推荐系统</p> -->
          <div class="info"></div>
        </div>
      </div>
      <div class="right">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginIndex",
};
</script> 

<style scoped lang="less">
.login-index {
  width: 70vw;
  height: 830px;
  // background-color: pink;
  margin: 0 auto;

  .top {
    height: 68px;
  }
  .main {
    height: 700px;
    width: 60vw;
    // background-color: bisque;

    margin: 0 auto;
    margin-top: 62px;
    display: flex;
    border: 1px solid rgb(204, 203, 203);
    border-radius: 10px;
    .left {
      width: 38vw;
      height: 698px;
      background: url("~@/assets/loginImg.jpeg");
      border-radius: 10px 0 0 10px;

      display: flex;
      align-items: center;
      .welcome-title {
        margin-left: 30px;
        .welcome {
          margin-bottom: 20px;
        }
      }
    }
    .right {
      width: 22vw;
      height: 698px;
      border-radius: 0 10px 10px 0;
      background-color: white;

      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }
  }
}
</style>