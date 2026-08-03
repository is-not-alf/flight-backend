package com.alf.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alf.testtask.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
  @EntityGraph(attributePaths = {"departureAirport", "arrivalAirport", "aircraft", "passengers"})
  Page<Flight> findAll(Pageable pageable);
}
