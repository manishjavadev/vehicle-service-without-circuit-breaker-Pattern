package com.manish.javadev.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.javadev.model.Vehicle;
import com.manish.javadev.model.VehicleResponseDetails;

@RestController
@RequestMapping(value = "/api")
public class VehicleServiceController {
	private Map<Integer, List<Vehicle>> vehicleMap;

	// Dummy Vehicle Data for userId 100
	public VehicleServiceController() {
		vehicleMap = new HashMap<Integer, List<Vehicle>>();

		List<Vehicle> vehicalList = Arrays.asList(new Vehicle(100, "Vertigo", "8081", "2018"),
				new Vehicle(101, "Celerio", "8082", "2019"));
		vehicleMap.put(new Integer(100), vehicalList);

	}

	@RequestMapping(value = "/vehicles/{userId}")
	public VehicleResponseDetails findVehicles(@PathVariable("userId") int userId) {
		List<Vehicle> vehicalList = vehicleMap.get(new Integer(userId));
		VehicleResponseDetails vehicleDetails = new VehicleResponseDetails(vehicalList);
		return vehicleDetails;
	}

	@RequestMapping(value = "/ping")
	public String ping() {
		return "Configuration is working fine";
	}
}
