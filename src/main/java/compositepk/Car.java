package compositepk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Car {

    @EmbeddedId
    private CarPrimaryKey id;

    private String maker;

    private String model;

    public Car() {
    }

    public CarPrimaryKey getId() {
        return id;
    }

    public void setId(CarPrimaryKey id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
