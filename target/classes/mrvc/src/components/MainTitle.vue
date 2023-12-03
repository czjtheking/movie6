<template>
  <div class="main-title">
    <h2>个性化电影推荐系统</h2>
    <div class="search">
      <input type="text" class="search-input" v-model="search_words" />
      <div class="el-icon-search search-icon" @click="goSearch"></div>
    </div>
    <div class="entry">
      <div class="option">
        <router-link to="/layout">首页</router-link>
      </div>
      <div class="option">
        <router-link to="/popular">热门榜单</router-link>
      </div>
      <div class="option">
        <router-link to="/recom">推荐</router-link>
      </div>
      <div class="user">
        <router-link
          to="/information"
          class="el-icon-user-solid human"
        ></router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainTitle",
  data() {
    return {
      search_words: "",
    };
  },
  methods: {
    goSearch() {
      if (this.search_words === "") {
        this.$message.warning({
          message: "请输入内容",
          duration: 1000,
          offset: 75,
        });
        return;
      }
      this.$router.push(
        {
          path: "/search",
          query: {
            searchWords: this.search_words,
          },
        },
        () => {},
        () => {}
      );
      // console.log(this.search_words);
    },
  },
};
</script>

<style scoped lang="less">
.main-title {
  height: 68px;
  width: 100vw;
  background: rgb(255, 255, 255, 0.5);

  display: flex;
  align-items: center;
  justify-content: space-between;

  position: fixed;
  z-index: 10;

  border-bottom: 1px solid rgb(204, 203, 203);

  .search:hover {
    background-color: white;
    .search-input {
      background-color: white;
    }
  }

  .search {
    height: 48px;
    width: 35vw;
    background-color: #ececec;

    display: flex;
    justify-content: space-evenly;
    align-items: center;

    border-radius: 10px;
    border: 1px solid rgb(204, 203, 203);
    padding-left: 2px;
    transition: 0.2s;
    .search-input {
      height: 37px;
      width: 32vw;
      background-color: #ececec;

      border: none;
      outline: none;
      border-radius: 10px;
      padding: 2px;
      transition: 0.2s;
    }
    .search-input:focus {
      background-color: #ececec;
    }
    .search-icon {
      height: 40px;
      width: 40px;

      display: flex;
      align-items: center;
      justify-content: center;
      transition: 0.2s;

      a {
        text-decoration: none;
        color: rgb(34, 33, 33);
        font-size: 25px;
      }
    }
    .search-icon:hover {
      background-color: #ececec;
      cursor: pointer;
      border-radius: 15px;
    }
  }

  .entry {
    height: 55px;
    width: 28vw;
    // background-color: blue;

    display: flex;
    justify-content: space-between;

    position: relative;
    .option {
      height: 55px;
      width: 70px;
      // background-color: gold;

      display: flex;
      align-items: center;
      justify-content: center;
      transition: 0.2s;
      a {
        height: 55px;
        width: 70px;
        line-height: 55px;
        text-align: center;
        text-decoration: none;
        color: rgb(34, 33, 33);
        font-size: 17px;
      }
    }
    .option:hover {
      padding-bottom: 18px;
    }
    .user {
      height: 55px;
      width: 55px;
      // background-color: red;

      margin-right: 1vw;
      display: flex;
      align-items: center;
      justify-content: center;
      .human {
        text-decoration: none;
        color: rgb(34, 33, 33);
        font-size: 40px;
      }
    }
  }
}

@media (max-width: 1200px) and (min-width: 600px) {
  .main-title {
    width: 1200px;
    .search {
      width: 420px;
      .search-input {
        width: 370px;
      }
    }
    .entry {
      width: 336px;
    }
  }
}

@media (max-width: 600px) {
  h2 {
    font-size: 15px;
  }
  .search {
    height: 30px;
  }
  .entry {
    height: 45px;
  }
  .option {
    display: none;
  }
  .user {
    height: 45px;
    width: 45px;
    position: absolute;
    right: 0;
    .human {
      font-size: 30px;
    }
  }
}
</style>