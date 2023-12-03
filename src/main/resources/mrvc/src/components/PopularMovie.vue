<template>
  <div class="popular-movie" @click="handleDetails">
    <div class="pic">
      <img :src="movie.img" alt="" width="100%" height="100%" />
    </div>
    <div class="context">
      <div class="movie-name">{{ movie.movie_name }}</div>
      <div class="genre">{{ movie.genre }}</div>
      <div class="actor">{{ movie.actor }}</div>
      <div class="movie-intro">{{ movie.movie_intro }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PopularMovie",
  props: ["movie"],
  methods: {
    handleDetails() {
      console.log(this.movie.movie_id);
      this.$router.push(
        {
          path: "/moviedetails",
          query: {
            movieId: this.movie.movie_id,
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
.popular-movie {
  height: 250px;
  width: 78vw;

  background-color: rgba(248, 247, 247, 0.5);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3), 0 20px 50px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(5px);
  border-radius: 10px;

  margin: 3px auto;

  display: flex;
  align-items: center;

  .pic {
    height: 240px;
    width: 12%;
    background-color: red;

    margin-left: 5px;
  }
  .context {
    height: 240px;
    width: 60%;

    margin-left: 10px;

    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    .movie-name {
      font-size: 25px;
    }
    .actor {
      font-size: 20px;
    }
    .genre {
      font-size: 20px;
    }
    .movie-intro {
      height: 40px;
      width: 100%;
      overflow: hidden;
    }
  }
}
.popular-movie:hover {
  cursor: pointer;
}
</style>