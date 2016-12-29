package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {

    public CashPayment() {
    }

    public CashPayment(long amount, Calendar date, Customer customer, Rental rental) {
        super(amount, date, customer, rental);
    }
}
