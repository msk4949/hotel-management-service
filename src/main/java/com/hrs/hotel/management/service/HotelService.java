package com.hrs.hotel.management.service;

import com.hrs.hotel.management.dto.HotelDto;
import com.hrs.hotel.management.dto.RoomDto;
import com.hrs.hotel.management.exception.ValidationException;
import com.hrs.hotel.management.model.Hotel;
import com.hrs.hotel.management.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::convertToHotelDto)
                .toList();
    }

    public HotelDto getHotelById(Long id) {
        var existingHotelOpt = hotelRepository.findById(id);
        if (existingHotelOpt.isPresent()) {
           var hotel = existingHotelOpt.get();
           return  convertToHotelDto(hotel);
        }else {
            throw new ValidationException("Hotel not found");
        }
    }

    public HotelDto saveHotel(HotelDto hotelDto) {

        var existingHotelOpt = Optional.ofNullable(hotelDto.getHotelId())
                .flatMap(hotelRepository::findById);

        Hotel hotel;
        if (existingHotelOpt.isPresent()) {
            hotel = existingHotelOpt.get();
            modelMapper.map(hotelDto, hotel);
        } else {
            hotel = modelMapper.map(hotelDto, Hotel.class);
        }
        hotel = hotelRepository.save(hotel);
        log.info("Hotel {} saved Successfully with id {}",hotel.getHotelName(), hotel.getId());
        return convertToHotelDto(hotel);
    }

    private HotelDto convertToHotelDto(Hotel hotel) {
        var dto = modelMapper.map(hotel, HotelDto.class);
        dto.getRooms().clear();
        hotel.getRooms().forEach(room -> {
            var roomdto = modelMapper.map(room, RoomDto.class);
            roomdto.setRoomNumber(room.getId().getRoomNumber());
            roomdto.setHotelId(null);
            roomdto.setHotelName(null);
            dto.getRooms().add(roomdto);
        });
        return dto;
    }
}