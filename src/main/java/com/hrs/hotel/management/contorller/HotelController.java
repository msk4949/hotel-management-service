package com.hrs.hotel.management.contorller;

import com.hrs.hotel.management.dto.HotelDto;
import com.hrs.hotel.management.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
@Slf4j
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/getAllHotels")
	public List<HotelDto> getAllHotels() {
		log.info("Received req for get all hotels");
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public HotelDto getHotelById(@PathVariable Long id) {
		log.info("Received req for get hotels by id {}", id);
		return hotelService.getHotelById(id);
	}

	@PostMapping("/saveHotel")
	public HotelDto saveHotel(@RequestBody HotelDto hotelDto) {
		log.info("Received req save Hotel {}", hotelDto);
		return hotelService.saveHotel(hotelDto);
	}


}