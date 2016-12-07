package app.model;

import javax.persistence.*;

/**
 * Created by jakub on 06.12.16.
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street;
    private int streetNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCity")
    private City city;

    public Address(String street, int streetNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
    }
}

@Entity
class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCountry")
    private Country country;

}

@Entity
class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int countryCode;
}
