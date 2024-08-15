package com.hrs.hotel.management.service;

import com.hrs.hotel.management.dto.RoomDto;
import com.hrs.hotel.management.exception.ValidationException;
import com.hrs.hotel.management.model.Room;
import com.hrs.hotel.management.model.RoomId;
import com.hrs.hotel.management.repository.HotelRepository;
import com.hrs.hotel.management.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private ModelMapper modelMapper;

	public RoomDto saveOrUpdateRoom(RoomDto roomDto) {
		var hotel = hotelRepository.findById(roomDto.getHotelId())
				.orElseThrow(() -> new ValidationException("Hotel not found"));

		var roomId = new RoomId(hotel.getId(), roomDto.getRoomNumber());
		Optional<Room> existingRoomOpt = roomRepository.findById(roomId);

		Room room;
		if (existingRoomOpt.isPresent()) {
			room = existingRoomOpt.get();
			modelMapper.map(roomDto, room);
		} else {
			room = modelMapper.map(roomDto, Room.class);
			room.setId(roomId);
			room.setHotel(hotel);
		}

		room = roomRepository.save(room);
		log.info("Room Saved Successfully");

		// Return the saved room as a DTO
		var response = modelMapper.map(room, RoomDto.class);
		response.setRoomNumber(room.getId().getRoomNumber());
		response.setHotelId(room.getId().getHotelId());
		response.setHotelName(room.getHotel().getHotelName());
		return response;
	}

}