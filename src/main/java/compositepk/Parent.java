package compositepk;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @EmbeddedId
    private ParentPK parentPK;

    private int age;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    List<Child> children = new ArrayList<>();

    public Parent(){}

    public ParentPK getParentPK() {
        return parentPK;
    }

    public void setParentPK(ParentPK parentPK) {
        this.parentPK = parentPK;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
