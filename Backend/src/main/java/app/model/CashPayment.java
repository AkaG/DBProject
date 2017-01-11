package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@DiscriminatorValue("CASH")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CashPayment extends Payment {

    public CashPayment() {
    }

    public CashPayment(long amount, Calendar date, Customer customer, Rental rental) {
        super(amount, date, customer, rental);
    }
}