<template>
  <div class="add-movie">
    <div class="title"><i class="el-icon-plus">电影添加</i></div>
    <el-input
      v-model="movie_name"
      placeholder="请输入电影名"
      class="movie-name a"
    ></el-input>

    <el-input
      v-model="genre"
      placeholder="请输入电影类别"
      class="genre a"
    ></el-input>
    <el-input
      v-model="director"
      placeholder="请输入电影导演"
      class="director a"
    ></el-input>
    <el-input
      v-model="actor"
      placeholder="请输入电影主演"
      class="acotr a"
    ></el-input>
    <el-input
      v-model="rate"
      placeholder="请输入电影评分"
      class="acotr a"
    ></el-input>
    <el-input
      v-model="movie_intro"
      placeholder="请输入电影简介"
      type="textarea"
      class="movie-intro a"
    ></el-input>
    <el-upload
      class="upload-demo"
      action="http://localhost/movies/uploadPic"
      :limit="1"
      :file-list="fileList"
      :on-change="handleFileUpload"
      :on-success="upload"
    >
      <!-- 修改action为提交路径 -->
      <el-button size="small" type="primary" class="a">上传电影海报</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
    </el-upload>
    <el-button type="primary" plain class="button" @click="submit"
      >提交
    </el-button>
  </div>
</template>

<script>
import { addMovie } from "@/api/addMovie";

export default {
  name: "addMovie",
  data() {
    return {
      movie_name: "",
      movie_intro: "",
      genre: "",
      director: "",
      actor: "",
      rate: "",
      fileList: [],
      img: "", //这个img保存的是图片相对路径，图片之前已经上传成功了，还缺拿取图片名补成相对路径
    };
  },
  methods: {
    handleFileUpload() {
      console.log(this.fileList);
    },
    async upload(res, file, fileList) {
      this.img = res.data;
      console.log(res.data, file, fileList);
    },
    async submit() {
      if (
        this.movie_name === "" ||
        this.movie_ === "" ||
        this.genre === "" ||
        this.director === "" ||
        this.actor === "" ||
        this.rate === "" ||
        this.img === ""
      ) {
        this.$message.warning({
          message: "内容不能为空",
          duration: 1000,
          offset: 75,
        });
        return;
      }
      console.log(
        this.movie_name,
        this.genre,
        this.director,
        this.actor,
        this.movie_intro,
        this.rate,
        this.img
      );
      const res = await addMovie(
        this.movie_name,
        this.genre,
        this.director,
        this.actor,
        this.movie_intro,
        this.rate,
        this.img
      );
      this.movie_name = "";
      this.movie_intro = "";
      this.genre = "";
      this.director = "";
      this.actor = "";
      this.rate = "";
      this.img = "";
      this.$message.success({
        message: "添加成功",
        duration: 1000,
        offset: 75,
      });
      console.log(res);
    },
  },
};
</script>

<style scoped lang="less">
.add-movie {
  padding: 20px;
  position: relative;
  padding-top: 10px;

  .title {
    height: 50px;
    line-height: 50px;
    padding-left: 0px;
    border-bottom: 1px solid #ddd;
    color: #00a1d6;
    font-size: 18px;
  }

  .a {
    width: 8vw;
    margin-top: 90px;
    margin-right: 50px;
  }

  .movie-intro {
    width: 51vw;
    height: 60px;
  }
  .upload-demo {
    width: 200px;
  }

  .button {
    position: absolute;
    bottom: 40px;
    right: 139px;
  }
}
</style>