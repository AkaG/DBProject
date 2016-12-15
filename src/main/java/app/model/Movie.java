package app.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jakub on 15.12.16.
 */

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
    @JoinColumn(name = "IdCategory")
    private List<Category> categories;
}
