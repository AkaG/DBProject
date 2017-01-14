package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "STAFF")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private double salary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    Address address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_rental_id")
    MovieRental movieRental;

    public Staff() {
    }

    public Staff(String name, String surname, double salary, Address address, MovieRental movieRental) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.address = address;
        this.movieRental = movieRental;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MovieRental getMovieRental() {
        return movieRental;
    }

    public void setMovieRental(MovieRental movieRental) {
        this.movieRental = movieRental;
    }
}