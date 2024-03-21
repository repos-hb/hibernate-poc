package compositepk;

import jakarta.persistence.*;

@Entity
public class Child {    // owner

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "firstname_fk", referencedColumnName = "firstname"),
            @JoinColumn(name = "lastname_fk", referencedColumnName = "lastname")
    })
    private Parent parent;

    public Child(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
