package mapping.collection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @ElementCollection
    @CollectionTable(name = "friend_nicknames",joinColumns = {@JoinColumn(name = "friend_id")})
    @Column(name = "nickname")
    private List<String> nicknames = new ArrayList<>();

    public Friend(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
    }
}
