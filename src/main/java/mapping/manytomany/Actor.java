package mapping.manytomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
