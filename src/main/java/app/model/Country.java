package app.model;

import javax.persistence.*;

/**
 * Created by jakub on 15.12.16.
 */
@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int countryCode;
}
