package app.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@Table(name = "CARD_PAYMENTS")
@DiscriminatorValue("CARD")
public class CardPayment extends Payment {
    @Column(nullable = false)
    private String accountId;
}
