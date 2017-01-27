package app.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="payment_type", discriminatorType=DiscriminatorType.STRING)
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
    protected Rental rental;

    public Payment() {
    }

    public Payment(long amount, Calendar date, Customer customer, Rental rental) {
        this.amount = amount;
        this.date = date;
        this.customer = customer;
        this.rental = rental;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}