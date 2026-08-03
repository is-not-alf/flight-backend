package com.alf.testtask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.alf.testtask.service.AirportService;
import com.alf.testtask.dto.AirportResponseDTO;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
  private final AirportService airportService;

  AirportController(AirportService airportService) {
    this.airportService = airportService;
  }

  @GetMapping
  public ResponseEntity<List<AirportResponseDTO>> getAirports() {
    return ResponseEntity.ok(airportService.getAirports());
  }
}
