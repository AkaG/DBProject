package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by jakub on 15.12.16.
 */
@Entity
@Table(name = "MOVIE_RENTALS")
public class MovieRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int[] phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAddress")
    Address address;

    @OneToMany(fetch = FetchType.LAZY)
    List<Staff> staff;
}
