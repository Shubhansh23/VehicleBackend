package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
}
