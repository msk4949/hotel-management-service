package com.hrs.hotel.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq", sequenceName = "hotel_sequence", allocationSize = 1)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "address")
    private String address;

    @Builder.Default
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();


}