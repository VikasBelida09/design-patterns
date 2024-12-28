package org.example.test.BookMyShow;

public class Movie {
    private String movieId;
    private String movieName;
    private double movieRuntime;
    private Cast cast;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(double movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public Cast getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast = cast;
    }
}
