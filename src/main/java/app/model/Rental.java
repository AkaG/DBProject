package app.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@Table(name = "RENTALS")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar rentalDate;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Staff staff;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Payment payment;
}
