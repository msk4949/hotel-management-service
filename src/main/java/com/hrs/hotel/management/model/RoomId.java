package com.hrs.hotel.management.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class RoomId implements Serializable {

    private Long hotelId;
    private String roomNumber;

    // Constructors
    public RoomId() {}

    public RoomId(Long hotelId, String roomNumber) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomId roomId = (RoomId) o;
        return Objects.equals(hotelId, roomId.hotelId) &&
                Objects.equals(roomNumber, roomId.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, roomNumber);
    }
}
