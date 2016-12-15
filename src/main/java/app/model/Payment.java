package app.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",discriminatorType=DiscriminatorType.STRING)
public abstract class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(nullable = false)
    protected long amount;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    protected Calendar date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected Customer customer;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    protected Rental rental;
}
