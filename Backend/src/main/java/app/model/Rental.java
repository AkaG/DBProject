package app.model;

import javax.persistence.*;
import java.util.Calendar;

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

    public Rental() {
    }

    public Rental(Calendar rentalDate, Calendar returnDate, Inventory inventory, Customer customer, Staff staff, Payment payment) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.inventory = inventory;
        this.customer = customer;
        this.staff = staff;
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Calendar rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}