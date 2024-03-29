package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIE_RENTALS",
        indexes = {
            @Index(columnList = "id", name = "movie_rental_id_idx"),
            @Index(columnList = "name", name = "movie_rental_name_idx")
        }
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedStoredProcedureQuery(
        name = "getMovieRentalMovies",
        procedureName = "list_mr_movies",
        resultClasses = {Movie.class},
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
        }
)
public class MovieRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    private Address address;

    @OneToMany(mappedBy = "movieRental", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Staff> staff;

    @OneToMany(mappedBy = "movieRental", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Inventory> inventories;

    public MovieRental() {
    }

    public MovieRental(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

}