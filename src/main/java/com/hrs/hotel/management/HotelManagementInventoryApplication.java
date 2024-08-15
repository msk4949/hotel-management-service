package com.hrs.hotel.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelManagementInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementInventoryApplication.class, args);
	}

}
