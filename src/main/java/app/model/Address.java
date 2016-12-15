package app.model;

import javax.persistence.*;

/**
 * Created by jakub on 06.12.16.
 */

@Entity
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
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
@Table(name = "CITIES")
class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCountry")
    private Country country;

}

@Entity
@Table(name = "COUNTRIES")
class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int countryCode;
}
