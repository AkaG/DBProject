package app.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jakub on 15.12.16.
 */

@Entity
@Table(name = "INVENTORIES")
public class Inventory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    MovieRental movieRental;

    @ManyToOne(fetch = FetchType.LAZY)
    Movie movie;

    @Column(nullable = false)
    private int amount;
}
