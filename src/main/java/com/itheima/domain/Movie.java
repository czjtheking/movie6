package com.itheima.domain;

public class Movie {
    private String moviePicURL;
    private String movieName;
    private String movieIntro;
    private String movieInfor;
    private Integer movieId;

    public String getMoviePicURL() {
        return moviePicURL;
    }

    public void setMoviePicURL(String moviePicURL) {
        this.moviePicURL = moviePicURL;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieIntro() {
        return movieIntro;
    }

    public void setMovieIntro(String movieIntro) {
        this.movieIntro = movieIntro;
    }

    public String getMovieInfor() {
        return movieInfor;
    }

    public void setMovieInfor(String movieInfor) {
        this.movieInfor = movieInfor;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moviePicURL='" + moviePicURL + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieIntro='" + movieIntro + '\'' +
                ", movieInfor='" + movieInfor + '\'' +
                ", movieId=" + movieId +
                '}';
    }
}
