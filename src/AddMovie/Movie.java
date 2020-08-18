package AddMovie;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Movie Object Class
 */
public class Movie {

    private String title;
    private String cast;
    private String producer;
    private String rating;
    private String genre;
    private String review;
    private String summary;
    private int price;
    private Image movieURL;

    /**
     * Constructor with all the details of the movie
     * @param title
     * @param cast
     * @param producer
     * @param rating
     * @param genre
     * @param review
     * @param summary
     * @param price
     * @param movieURL
     */
    public Movie (String title, String cast, String producer, String rating, String genre, String review, String summary, int price, String movieURL){
        this.title = title;
        this.cast = cast;
        this.producer = producer;
        this.rating = rating;
        this.genre = genre;
        this.review = review;
        this.summary = summary;
        this.price = price;
        this.movieURL = new Image(new File(System.getProperty("user.dir") + movieURL).toURI().toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Image getMovieURL() {
        return movieURL;
    }

    public void setMovieURL(Image movieURL) {
        this.movieURL = movieURL;
    }


    /**
     * Reads database of movies
     * @return Arraylist of all movies
     * @throws IOException
     */
    public static ArrayList<Movie> readingMovieDB() throws IOException {

        ArrayList<Movie> movie = new ArrayList<>();

        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "/src/AddMovie/Movies.txt"));
        scan.useDelimiter("[,\n]");

        while (scan.hasNext()) {

            movie.add(new Movie(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.nextInt(), scan.next()));
        }
        scan.close();

        return movie;
    }

}
