package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Vehicle;
import com.nit.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	
	 @Autowired
	    private VehicleRepository vehicleRepository;

	    public List<Vehicle> getVehicles() {
	        return vehicleRepository.findAll();
	    }

	    public Optional<Vehicle> getVehicle(Long id) {
	        return vehicleRepository.findById(id);
	    }

	    public Vehicle createVehicle(Vehicle vehicle) {
	        return vehicleRepository.save(vehicle);
	    }

	    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
	        Vehicle vehicle = vehicleRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

	        vehicle.setMake(updatedVehicle.getMake());
	        vehicle.setModel(updatedVehicle.getModel());
	        vehicle.setYear(updatedVehicle.getYear());
	        vehicle.setVin(updatedVehicle.getVin());

	        return vehicleRepository.save(vehicle);
	    }

	    public void deleteVehicle(Long id) {
	        vehicleRepository.deleteById(id);
	    }
}
