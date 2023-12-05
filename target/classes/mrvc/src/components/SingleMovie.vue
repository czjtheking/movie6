<template>
  <div class="single-movie" @click="handleDetails">
    <img
      :src="movie.moviePicURL"
      alt=""
      width="100%"
      height="100%"
      class="movie-img"
    />
    <div class="info">
      <p class="name-m">{{ movie.movieName }}</p>
      <p class="actor-m">{{ movie.movieActor }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "SingleMovie",
  props: ["movie"],
  methods: {
    handleDetails() {
      this.$router.push(
        {
          path: "/moviedetails",
          query: {
            id: this.movie.movieId,
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
.single-movie {
  width: 15vw;
  height: 390px;
  // background-color: rgb(160, 150, 150);
  background: repeat-y top left/100%;

  display: flex;
  flex-direction: column-reverse;

  overflow: hidden;
  position: relative;
  border-radius: 8px;

  .movie-img {
    position: absolute;
  }
  .info {
    width: 18vw;
    height: 120px;
    margin-bottom: -120px;
    transition: 0.3s;

    background-color: rgba(255, 255, 255, 0.5);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3), 0 20px 50px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(5px);

    .name-m {
      font-size: 20px;
      margin-bottom: 10px;
    }
  }
}
.single-movie:hover {
  .info {
    margin-bottom: 0;
  }
}
.single-movie:hover {
  cursor: pointer;
}
</style>