package com.hrs.hotel.management.repository;

import com.hrs.hotel.management.model.Room;
import com.hrs.hotel.management.model.RoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, RoomId>{

}