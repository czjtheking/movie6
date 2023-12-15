package com.itheima.domain;

public class MovieSimilarity {
    private Movie movie;
    private double similarity;

    public MovieSimilarity(Movie movie, double similarity) {
        this.movie = movie;
        this.similarity = similarity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "MovieSimilarity{" +
                "movie=" + movie +
                ", similarity=" + similarity +
                '}';
    }
}
