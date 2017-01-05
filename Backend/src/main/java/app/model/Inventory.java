package app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVENTORIES")
public class Inventory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    MovieRental movieRental;

    @ManyToOne(fetch = FetchType.LAZY)
    Movie movie;

    @Column(nullable = false)
    private int amount;

    public Inventory() {
    }

    public Inventory(MovieRental movieRental, Movie movie, int amount) {
        this.movieRental = movieRental;
        this.movie = movie;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MovieRental getMovieRental() {
        return movieRental;
    }

    public void setMovieRental(MovieRental movieRental) {
        this.movieRental = movieRental;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}