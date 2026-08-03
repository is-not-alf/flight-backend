package com.alf.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alf.testtask.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
  
}
