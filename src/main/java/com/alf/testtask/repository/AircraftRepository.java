package com.alf.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alf.testtask.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
  
}
