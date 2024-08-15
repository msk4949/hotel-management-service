package com.hrs.hotel.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="room")
public class Room {

    @EmbeddedId
    private RoomId id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @MapsId("hotelId")
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}