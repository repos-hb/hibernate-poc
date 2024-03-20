package mapping.manytomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movie_actor",
            joinColumns={@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
