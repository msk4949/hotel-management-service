package com.hrs.hotel.management.repository;

import com.hrs.hotel.management.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}