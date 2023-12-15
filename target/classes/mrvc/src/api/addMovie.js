import request from '@/utils/request'

export const addMovie = (movieName, movieGenre, movieDirector, movieActor, movieIntro, movieRate, moviePicURL) => {
  return request.post("/movies/add", { //这个路径后面要修改

    movieName,
    movieGenre,
    movieDirector,
    movieActor,
    movieIntro,
    movieRate,
    moviePicURL

  });
}