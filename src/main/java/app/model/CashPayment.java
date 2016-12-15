package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@Table(name = "CASH_PAYMENTS")
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {

}
