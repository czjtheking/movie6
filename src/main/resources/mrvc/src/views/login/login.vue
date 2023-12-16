<template>
  <div class="login-login">
    <div class="login-title">登录</div>
    <el-input
      v-model="account"
      placeholder="请输入账号"
      class="input"
    ></el-input>
    <el-input
      v-model="password"
      placeholder="请输入密码"
      class="input"
      show-password
    ></el-input>
    <div class="choose">
      <el-radio v-model="user_ad" label="1">用户</el-radio>
      <el-radio v-model="user_ad" label="2">管理员</el-radio>
    </div>
    <el-button type="primary" plain class="login" @click="login"
      >登录</el-button
    >
    <el-link type="primary" class="register" @click="register"
      >点击注册</el-link
    >
  </div>
</template>

<script>
import { codeLogin } from "@/api/login";

export default {
  name: "LoginLogin",
  data() {
    return {
      account: "",
      password: "",
      user_ad: "1",
      iisAdmin: false,
    };
  },
  methods: {
    // 登录
    async login() {
      if (this.account === "") {
        this.$message.warning("账号不能为空");
      } else if (this.password === "") {
        this.$message.warning("密码不能为空");
      } else {
        if (this.user_ad === "1") this.iisAdmin = false;
        else this.iisAdmin = true;

        const res = await codeLogin(this.account, this.password, this.iisAdmin);
        this.$store.commit("user/setUserInfo", {
          userId: res.data.userId,
          isAdmin: res.data.userAd,
          userName: res.data.userName,
          userAvatar: res.data.userAvatar,
        }); //提交userInfo存储 是
        console.log(res);
        this.$message.success({
          message: "登陆成功",
          duration: 1000,
          offset: 75,
        });
        this.$router.push("/layout");
      }
    },
    register() {
      this.$router.push("/register");
    },
  },
  // created() {
  //   localStorage.clear();
  // },
};
</script>

<style scoped lang="less">
.login-login {
  width: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  .login-title {
    font-size: 28px;
    color: #44484e;
    font-weight: 600;
    margin-bottom: 50px;
  }
  .input {
    width: 70%;
    margin-bottom: 5px;
  }
  .choose {
    margin-bottom: 10px;
  }
  .login {
    margin-bottom: 10px;
  }
  .register {
    margin-bottom: 10px;
  }
}
</style>