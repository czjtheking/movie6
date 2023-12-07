<template>
  <div class="movie-commetDtails">
    <div
      class="bgi"
      :style="{
        backgroundImage: 'url(' + movie_img + ')',
        backgroundSize: '100% ',
      }"
    ></div>
    <div class="top"></div>
    <div class="title"></div>
    <div class="main">
      <div class="pic">
        <img :src="movie_img" alt="" referrerpolicy="no-referrer" />
      </div>
      <div class="text">
        <div class="movie-title">{{ movie_name }}</div>
        <div class="movie-genre">{{ movie_genre }}</div>
        <div class="movie-director">{{ movie_director }}</div>
        <div class="movie-actor">{{ movie_actor }}</div>
        <div class="movie-intro">{{ movie_intro }}</div>
        <el-rate
          v-model="movie_rate"
          disabled
          show-score
          text-color="#ff9900"
          score-template="{value}"
          :max="10"
        >
        </el-rate>
      </div>
    </div>
    <div class="store">
      点击收藏<el-button
        type="warning"
        plain
        icon="el-icon-star-off"
        circle
        class="store-button"
        @click="handleStore"
      ></el-button>
    </div>
    <div class="link">
      <div class="link-title">播放链接</div>
      <a :href="movie_link" class="link_" target="_blank">{{ movie_link }}</a>
    </div>
    <div class="rate">
      评分
      <el-rate
        v-model="rateNum"
        :colors="colors"
        :allow-half="true"
        @change="setRate"
        class="stars"
        :max="10"
      >
      </el-rate>
    </div>
    <div class="comment">
      <p class="pl">评论</p>
      <div class="box">
        <div class="head"></div>
        <div class="box2">
          <textarea
            maxlength="200"
            class="text1"
            name="text_"
            id=""
            cols="30"
            rows="10"
            placeholder="发布一条友善的评论"
            @focus="setFocus"
            @blur="delFocus"
            @input="setNum"
            ref="textRef"
          ></textarea>
          <span class="dontsee" ref="textNum">{{ textnum0 }}/200字</span>
        </div>

        <button class="btn" ref="publishBtn" @click="publish">发布</button>
      </div>

      <div class="box3" ref="newComment">
        <ul>
          <li v-for="(item, index) in userComments" :key="index">
            <div class="comment2">
              <p class="name" ref="u_name">{{ item.userName }}</p>
              <p class="par" ref="u_par">{{ item.context }}</p>
              <p class="time" ref="u_time">{{ item.date }}</p>
            </div>
            <div class="delete" ref="deteteRef" v-if="isAdmin">
              <el-button
                slot="reference"
                class="delete-btn"
                type="danger"
                @click="deleteComment(item.commentId)"
                ><i class="el-icon-delete"></i
              ></el-button>
            </div>
          </li>
        </ul>
      </div>
      <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
        <span>是否删除该评论</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="confirmDelete">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import store from "@/store";
import {
  newComment,
  storeMovie,
  // rateMovie,
  getMovieDetails,
  deleteComments,
} from "@/api/movieDetails";

export default {
  name: "MoviedetailsIndex",
  data() {
    return {
      dialogVisible: false,
      nowCommentId: 0,
      idAdmin: false,
      movie_id: 123,
      movie_name: "",
      movie_genre: "",
      movie_director: "",
      movie_actor: "",
      movie_intro: "",
      movie_img: require("@/assets/test2.jpg"),
      movie_rate: 8.5,
      movie_link: "暂无",
      rateNum: 0,
      textnum0: 0,
      colors: ["#99A9BF", "#F7BA2A", "#FF9900"],
      userComments: [],
    };
  },
  methods: {
    async setRate() {
      // const res = await rateMovie(
      //   store.getters.getUserId,
      //   this.movie_id,
      //   this.rateNum
      // );
      this.$message.success({
        message: "评分成功",
        duration: 1000,
        offset: 75,
      });
      //console.log();
    },
    setFocus() {
      this.$refs.textRef.classList.remove("text1");
      this.$refs.textRef.classList.add("text2");
      this.$refs.publishBtn.classList.add("longer");
      this.$refs.textNum.classList.remove("dontsee");
    },
    delFocus() {
      this.$refs.textRef.classList.remove("text2");
      this.$refs.textRef.classList.add("text1");
      this.$refs.publishBtn.classList.remove("longer");
      this.$refs.textNum.classList.add("dontsee");
    },
    setNum() {
      this.textnum0 = this.$refs.textRef.value.length;
    },
    async publish() {
      //发布评论，提交数据给服务器，提交成功后改变数组渲染新评论
      let str = this.$refs.textRef.value;
      if (str.trim() === "") {
        console.log();
      } else {
        const obj = {
          user_id: store.getters.getUserId,
          movie_id: this.movie_id,
          user_name: store.getters.getUserName,
          context: this.$refs.textRef.value,
          date: new Date().toLocaleString(),
        };
        console.log(obj);
        const res = await newComment(
          Number(obj.user_id),
          Number(obj.movie_id),
          obj.user_name,
          obj.context,
          obj.date
        );
        this.userComments.unshift(obj);
        console.log(res);
        this.$refs.textRef.value = null;
        this.textnum0 = 0;
      }
    },
    async handleStore() {
      //用户点击收藏，提交收藏请求
      const res = await storeMovie(
        Number(store.getters.getUserId),
        Number(this.movie_id)
      );
      this.$message.success({
        message: "收藏成功",
        duration: 1000,
        offset: 75,
      });
      console.log(res);
    },
    deleteComment(id) {
      this.dialogVisible = true;
      this.nowCommentId = id;
      console.log("删除:", id);
    },
    async confirmDelete() {
      this.dialogVisible = false;
      console.log("删除:", this.nowCommentId);
      const res = await deleteComments(Number(this.nowCommentId));
      //从网页中遍历删除指定评论
      this.userComments.forEach((ele, index) => {
        if (ele.commentId === this.nowCommentId) {
          this.userComments.splice(index, 1);
        }
      });
      this.$message.success({
        message: "删除成功",
        duration: 1000,
        offset: 75,
      });
      console.log(res);
    },
  },
  async created() {
    this.isAdmin = store.getters.getAuth;
    this.$store.commit("info/setInfoMark", 1);
    //进入电影详情页，根据movie_id请求电影和评论数据，进行渲染
    console.log(Number(this.getMovieId));
    const res = await getMovieDetails(Number(this.getMovieId));
    this.movie_id = res.data.movie.movieId;
    this.movie_name = res.data.movie.movieName;
    this.movie_genre = res.data.movie.movieGenre;
    this.movie_director = res.data.movie.movieDirector;
    this.movie_actor = res.data.movie.movieActor;
    this.movie_intro = res.data.movie.movieIntro;
    this.movie_img = res.data.movie.moviePicURL;
    this.movie_rate = res.data.movie.movieRate;
    this.movie_link = "暂无";
    this.userComments = res.data.commentList;
    console.log(res);
  },
  computed: {
    getMovieId() {
      return this.$route.query.id;
    },
  },
};
</script>

<style scoped lang="less">
.movie-commetDtails {
  width: 99vw;
  color: #2e2c2c;

  .bgi {
    width: 100%;
    height: 100%;
    position: fixed;
    background-size: 100% 100%;
    z-index: -1;
    filter: blur(5px);
  }
  .top {
    height: 68px;
  }
  .title {
    height: 60px;
    width: 90vw;
    // background-color: green;
    font-size: 40px;

    margin: 0 auto;
  }
  .main {
    background: rgba(255, 255, 255, 0.5);
    border: 1px solid #ccc;
    box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5);

    height: 500px;
    width: 80vw;
    // background-color: white;
    border-radius: 10px;
    margin: 0 auto;
    margin-bottom: 10px;

    display: flex;
    padding: 10px;
    .pic {
      height: 480px;
      width: 18vw;
      // background-color: rebeccapurple;
      img {
        height: 100%;
        width: 100%;
        border-radius: 8px;
      }
    }
    .text {
      height: 480px;
      width: 55vw;
      margin-left: 20px;
      .movie-title {
        font-size: 40px;
      }
      .movie-genre {
        margin-top: 100px;
        font-size: 20px;
      }
      .movie-actor {
        margin-top: 30px;

        font-size: 20px;
      }
      .movie-director {
        margin-top: 30px;
        font-size: 20px;
      }
      .movie-intro {
        margin-top: 50px;
        font-size: 20px;
        height: 100px;
      }
    }
  }
  .store {
    background: rgba(255, 255, 255, 0.5);
    border: 1px solid #ccc;
    box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5);

    height: 50px;
    width: 80vw;
    // background-color: white;
    border-radius: 10px;
    line-height: 50px;
    font-size: 20px;

    margin: 0 auto;
    margin-bottom: 10px;
    display: flex;
    align-items: center;
    justify-content: right;
    .store-button {
      margin: 0 10px;
    }
  }
  .link {
    background: rgba(255, 255, 255, 0.5);
    border: 1px solid #ccc;
    box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5);

    height: 60px;
    width: 80vw;
    // background-color: white;
    border-radius: 10px;
    font-size: 20px;
    line-height: 50px;

    margin: 0 auto;
    margin-bottom: 10px;
    padding-left: 10px;
    display: flex;
    align-items: center;

    .link_ {
      text-decoration: none;
      color: #2e2c2c;
      margin-left: 6vw;
    }
    .link_:hover {
      color: rgb(0, 153, 255);
    }
  }
  .rate {
    background: rgba(255, 255, 255, 0.5);
    border: 1px solid #ccc;
    box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5);

    height: 60px;
    width: 80vw;
    // background-color: white;
    border-radius: 10px;
    font-size: 20px;
    line-height: 50px;

    padding-left: 10px;
    margin: 0 auto;
    margin-bottom: 10px;
    display: flex;
    align-items: center;
    .stars {
      margin-left: 8vw;
    }
  }
  .comment {
    height: 110px;
    width: 80vw;
    background: rgba(255, 255, 255, 0.5);
    border: 1px solid #ccc;
    box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5);

    border-radius: 10px;
    font-size: 20px;

    margin: 0 auto;
    position: relative;
    .pl {
      margin-left: 10px;
      margin-top: 17px;
      position: absolute;
    }
    .box {
      margin: 0 auto;
      margin-bottom: 10px;
      width: 80vw;
      height: 110px;
      // background-color: pink;

      display: flex;
      justify-content: space-evenly;
      align-items: flex-start;
    }

    .box2 textarea {
      transition: all 0.1s;
    }

    .box2 textarea:hover {
      background-color: rgb(255, 255, 255);
      box-shadow: 0.5px 0.5px 2px 0.5px rgba(0, 0, 0, 0.5);
    }

    .text2 {
      width: 55vw;
      height: 80px;
      background-color: rgb(255, 255, 255);
      border-radius: 8px;
      padding: 5px;
      border: 1px solid gray;
      box-shadow: 0.5px 0.5px 2px 0.5px rgba(0, 0, 0, 0.5);
      outline: none;
    }

    .text1 {
      width: 55vw;
      height: 66px;
      border: 0;
      background: 0;
      background-color: #ececec;
      padding: 5px;
      border-radius: 8px;
      outline: none;
    }

    .dontinput {
      pointer-events: none;
    }

    .box2 {
      margin-top: 10px;

      position: relative;
    }

    .box2 span {
      position: absolute;
      font-size: 14px;
      bottom: -15px;
      right: 2px;
      color: #8a8a8a;
    }

    .dontsee {
      display: none;
    }

    .btn {
      width: 80px;
      height: 66px;
      background-color: rgb(0, 193, 252);
      color: white;
      border-radius: 8px;
      text-align: center;
      line-height: 66px;
      border: 0;
      margin-top: 10px;
    }

    button.longer {
      height: 80px;
      line-height: 80px;
    }

    .btn:hover {
      background-color: rgb(73, 213, 255);
      cursor: pointer;
    }

    .box3 {
      margin: 10px auto;
      width: 80vw;

      border-radius: 8px;
      padding-bottom: 10px;

      // height: 600px;
      /* background-color: pink; */
    }

    .box3 ul {
      width: 100%;
      height: 100%;
    }

    .box3 li {
      width: 66vw;
      height: 80px;
      /* background-color: red; */
      margin-top: 5px;
      margin-left: 9vw;
      list-style: none;
      display: flex;

      background: rgba(255, 255, 255, 0.7);
      box-shadow: 0.5px 0.5px 2px 0.5px rgba(0, 0, 0, 0.5);

      border-radius: 10px;

      .delete {
        margin-top: 25px;
        .deletePop {
          font-size: 10px;
        }
        .delete-btn {
          width: 40px;
          height: 30px;
          text-align: center;
          line-height: 20px;

          padding: 0;
          margin: 0;
          margin-right: 10px;
        }
      }
    }

    .box3 .comment2 {
      flex: 1;
      height: 80px;

      margin-left: 15px;
      padding: 4px;
      padding-top: 0;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      border-bottom: 1px solid rgb(204, 203, 203);
    }

    .box3 .name {
      font-size: 14px;
      font-weight: bold;
      color: #f31f70;
    }

    .box3 .par {
      font-size: 15px;
    }

    .box3 .time {
      font-size: 8px;
      color: #8a8a8a;
    }
  }
}
</style>