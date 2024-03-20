package compositepk;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarPrimaryKey implements Serializable {

    private String chasisNo;
    private String engineNo;

    public CarPrimaryKey() {
    }

    public CarPrimaryKey(String chasisNo, String engineNo) {
        this.chasisNo = chasisNo;
        this.engineNo = engineNo;
    }

    public String getChasisNo() {
        return chasisNo;
    }

    public void setChasisNo(String chasisNo) {
        this.chasisNo = chasisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPrimaryKey that = (CarPrimaryKey) o;
        return Objects.equals(chasisNo, that.chasisNo) && Objects.equals(engineNo, that.engineNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chasisNo, engineNo);
    }
}
