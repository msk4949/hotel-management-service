package com.hrs.hotel.management.config;

import com.hrs.hotel.management.dto.HotelDto;
import com.hrs.hotel.management.model.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
