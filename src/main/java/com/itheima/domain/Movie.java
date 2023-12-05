package com.itheima.domain;

public class Movie {
    private String moviePicURL;
    private String movieName;
    private String movieActor;
    private String movieIntro;
    private Integer movieId;
    private String movieDirector;
    private double movieRate;
    private String movieGenre;

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

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieIntro() {
        return movieIntro;
    }

    public void setMovieIntro(String movieIntro) {
        this.movieIntro = movieIntro;
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
                ", movieActor='" + movieActor + '\'' +
                ", movieInfor='" + movieIntro + '\'' +
                ", movieId=" + movieId +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieRate='" + movieRate + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                '}';
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public double getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(double movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }
}
