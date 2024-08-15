package com.hrs.hotel.management.contorller;

import com.hrs.hotel.management.dto.RoomDto;
import com.hrs.hotel.management.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/room")
@Slf4j
public class RoomController {
    @Autowired
    private RoomService roomService;


    @PostMapping("/saveRoom")
    public RoomDto saveRoom(@RequestBody RoomDto roomDto) {
        log.info("Received req save Room {}", roomDto);
        return roomService.saveOrUpdateRoom(roomDto);
    }


}