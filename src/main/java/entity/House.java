package entity;

import jakarta.persistence.*;

@Entity
public class House {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @Embedded
    private Room room;

    public House() {
    }

    public House(Address address, Room room) {
        this.address = address;
        this.room = room;
    }
}
