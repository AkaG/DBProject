package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIE_RENTALS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedStoredProcedureQuery(
        name = "MovieRental.getMovies",
        procedureName = "list_mr_movies",
        resultClasses = Movie.class,
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Staff> staff;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Inventory> inventories;

    public MovieRental() {
    }

    public MovieRental(String name, String phone, Address address, List<Staff> staff, List<Inventory> inventories) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.staff = staff;
        this.inventories = inventories;
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

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}