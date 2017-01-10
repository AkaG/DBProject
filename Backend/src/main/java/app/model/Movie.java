package app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIES")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    private int rating;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, int rating, String description, List<Category> categories) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}