package com.hrs.hotel.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoomDto {
	private Long hotelId;
	private String hotelName;
	private String roomNumber;
	private String roomType;
	private int price;
}