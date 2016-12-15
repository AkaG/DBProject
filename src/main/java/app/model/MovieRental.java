package app.model;

import javax.persistence.*;
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
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Staff> staff;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Inventory> inventories;
}
