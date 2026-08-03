package com.alf.testtask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.alf.testtask.service.AircraftService;
import com.alf.testtask.dto.AircraftResponseDTO;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {
  private final AircraftService aircraftService;

  AircraftController(AircraftService aircraftService) {
    this.aircraftService = aircraftService;
  }

  @GetMapping
  public ResponseEntity<List<AircraftResponseDTO>> getAircrafts() {
    return ResponseEntity.ok(aircraftService.getAircrafts());
  }
}
