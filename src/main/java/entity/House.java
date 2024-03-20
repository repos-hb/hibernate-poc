package entity;

import jakarta.persistence.*;

@Entity
public class House {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "address_zipcode"))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="length", column = @Column(name = "room_length")),
            @AttributeOverride(name="height", column = @Column(name = "room_height")),
            @AttributeOverride(name="width", column = @Column(name = "room_width"))
    })
    private Room room;

    public House() {
    }

    public House(Address address, Room room) {
        this.address = address;
        this.room = room;
    }
}
