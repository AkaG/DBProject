package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jakub on 15.12.16.
 */
@Entity
@Table(name = "STAFF")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAddress")
    Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMovieRental")
    MovieRental movieRental;
}
