package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.model.Vehicle;

public interface VehicleService {

	public List<Vehicle> getVehicles();

	public Optional<Vehicle> getVehicle(Long id);

	public Vehicle createVehicle(Vehicle vehicle);

	public Vehicle updateVehicle(Long id, Vehicle updatedVehicle);
	
	public void deleteVehicle(Long id);

}
