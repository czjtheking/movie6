<template>
  <div class="my-info">
    <div class="title"><i class="el-icon-notebook-1">个人信息</i></div>
    <div class="ava">
      头像:
      <el-upload
        class="avatar-uploader"
        action="http://localhost/users/avatar"
        :data="{ userId: uid }"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
      >
        <img v-if="avatarURL" :src="avatarURL" class="avatar" />
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
    </div>

    <div class="uid">uid:{{ uid }}</div>
    <div class="uname">
      <div v-if="isShowEditUname">
        昵称:
        <el-input
          v-model="uname"
          placeholder="请输入昵称"
          class="uname-context"
        ></el-input>
        <el-button type="primary" plain class="button" @click="updateName"
          >确认</el-button
        >
      </div>
      <div v-else>
        昵称:
        <span class="uname-context">{{ uname }}</span>
        <el-button type="primary" plain class="button" @click="handleEditUname"
          >点击修改</el-button
        >
      </div>
    </div>
    <div class="account">账号:{{ account }}</div>
    <div class="password">
      <div v-if="isShowEditPassword">
        密码:
        <el-input
          v-model="password"
          placeholder="请输入昵称"
          class="password-context"
          show-password
        ></el-input>
        <el-button type="primary" plain class="button" @click="updatePassword"
          >确认</el-button
        >
      </div>
      <div v-else>
        密码:
        <span class="password-context">*******</span>
        <el-button
          type="primary"
          plain
          class="button"
          @click="handleEditPassword"
          >点击修改</el-button
        >
      </div>
    </div>
    <div class="gologin">
      <el-link type="primary" @click="gologin">切换账号</el-link>
    </div>
  </div>
</template>

<script>
import {
  getUserData,
  updateUserName,
  updateUserPassword,
} from "@/api/userInfo";
import store from "@/store";

export default {
  name: "MyInfor",
  data() {
    return {
      uid: 0,
      uname: "",
      account: "",
      password: "",
      isShowEditUname: false,
      isShowEditPassword: false,
      avatarURL: "", //这里默认测试
    };
  },
  methods: {
    gologin() {
      this.$router.push(
        {
          path: "/login",
          query: {
            searchWords: this.search_words,
          },
        },
        () => {},
        () => {}
      );
    },
    handleAvatarSuccess(res, file) {
      console.log("修改头像结果：", res, file);
      this.avatarUrl = res.data;
      this.$store.commit("user/setUserInfo", {
        userId: store.getters.getUserId,
        isAdmin: store.getters.getAuth,
        userName: store.getters.getUserName,
        userAvatar: res.data,
      }); //提交userInfo存储 是
      location.reload();
    },
    handleEditUname() {
      this.isShowEditUname = true;
    },
    handleEditPassword() {
      this.isShowEditPassword = true;
    },
    async updateName() {
      //点击请求修改昵称
      const res = await updateUserName(Number(this.uid), this.uname);
      this.$store.commit("user/setUserInfo", {
        userId: store.getters.getUserId,
        isAdmin: store.getters.getAuth,
        userName: this.uname,
        userAvatar: store.getters.getUserAvatar,
      }); //提交userInfo存储
      this.isShowEditUname = false;
      this.$message.success("修改成功");
      console.log(res);
    },
    async updatePassword() {
      //点击请求修改密码
      const res = await updateUserPassword(Number(this.uid), this.password);
      this.isShowEditPassword = false;
      this.$message.success("修改成功");
      console.log(res);
    },
  },
  async created() {
    this.uid = store.getters.getUserId; //创建页面时，拿取uid然后发起请求获取个人信息
    const res = await getUserData(Number(store.getters.getUserId));
    this.uname = res.data.userName;
    this.account = res.data.userAccount;
    this.password = res.data.userPsw;
    this.avatarURL = store.getters.getUserAvatar;
    console.log(res);
  },
};
</script>

<style scoped lang="less">
.my-info {
  width: 100%;
  height: 100%;

  padding: 20px;
  padding-top: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #44484e;
  .title {
    height: 50px;
    line-height: 50px;
    padding-left: 0px;
    border-bottom: 1px solid #ddd;
    color: #00a1d6;
    font-size: 18px;
  }
  .ava {
    display: flex;
    margin-top: 10px;
    .avatar-uploader {
      width: 178px;
      height: 178px;
      border: 1px solid #d8d2d2;
      border-radius: 10px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      margin-left: 20px;
    }
    .avatar-uploader:hover {
      border-color: #409eff;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 178px;
      height: 178px;
      line-height: 178px;
      text-align: center;
    }
    .avatar {
      width: 178px;
      height: 178px;
      display: block;
    }
  }

  .uid {
    line-height: 50px;
    height: 50px;
  }
  .uname {
    height: 50px;
    line-height: 50px;
    .uname-context {
      display: inline-block;
      width: 200px;
      margin-right: 10px;
    }
  }
  .account {
    height: 50px;
    line-height: 50px;
  }
  .password {
    height: 50px;
    line-height: 50px;
    margin-bottom: 20px;
    .password-context {
      display: inline-block;
      margin-right: 10px;
      width: 200px;
    }
  }
  .button {
    width: 70px;
    height: 30px;
    padding: 0;
    font-size: 13px;
    text-align: center;
  }
  .gologin {
    margin-bottom: 450px;
  }
}
</style>