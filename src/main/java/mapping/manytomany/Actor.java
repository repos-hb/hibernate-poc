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

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.PERSIST)
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

    public void setMovies(Movie movie) {
//        this.movies = movies;
        getMovies().add(movie);
        movie.getActors().add(this);
    }

    public void removeMovies(Movie movie){
        getMovies().remove(movie);
        movie.getActors().remove(this);
    }
}
