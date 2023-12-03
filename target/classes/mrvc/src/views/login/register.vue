<template>
  <div class="login-register">
    <div class="register-title">注册</div>
    <el-input
      v-model="account"
      placeholder="请输入账号"
      class="input"
    ></el-input>
    <el-input
      v-model="password"
      placeholder="请输入密码"
      class="input"
    ></el-input>
    <br />
    <el-button type="primary" plain class="register" @click="register"
      >注册</el-button
    >
    <el-link type="primary" class="login" @click="goToLogin">返回登陆</el-link>
  </div>
</template>

<script>
import { codeRegister } from "@/api/login";

export default {
  name: "LoginRegister",
  data() {
    return {
      account: "",
      password: "",
    };
  },
  methods: {
    async register() {
      if (this.account === "") {
        this.$message.warning("账号不能为空");
      } else if (this.password === "") {
        this.$message.warning("密码不能为空");
      } else {
        const res = await codeRegister(this.account, this.password);
        console.log(res);
        this.$message.success("注册成功，请登录");
        this.$router.push("/mainlogin");
      }
    },
    goToLogin() {
      this.$router.push({
        path: "/mainlogin",
      });
    },
  },
};
</script>

<style scoped lang="less">
.login-register {
  width: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  .register-title {
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
  .register {
    margin-bottom: 10px;
  }
  .login {
    margin-bottom: 10px;
  }
}
</style>