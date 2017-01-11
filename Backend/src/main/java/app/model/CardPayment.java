package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@DiscriminatorValue("CARD")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CardPayment extends Payment {
    private String accountId;

    public CardPayment() {
    }

    public CardPayment(long amount, Calendar date, Customer customer, Rental rental, String accountId) {
        super(amount, date, customer, rental);
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}