import request from '@/utils/request'

export const addMovie = (moviename, movieintro, genre, director, actor, img) => {
  return request.post("/passport/login", { //这个路径后面要修改
    form: {
      moviename,
      movieintro,
      genre,
      director,
      actor,
      img,
    }
  });
}