import request from '@/utils/request'

export const addMovie = (movieName, movieGenre, movieDirector, movieActor, movieIntro, moviePicURL) => {
  return request.post("/movies/add", { //这个路径后面要修改

    movieName,
    movieGenre,
    movieDirector,
    movieActor,
    movieIntro,
    moviePicURL,

  });
}