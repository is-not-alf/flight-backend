package com.alf.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.alf.testtask.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
  List<Passenger> findByFlightId(Long flightId);
}
