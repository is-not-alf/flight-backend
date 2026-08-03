package com.alf.testtask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.alf.testtask.service.FlightService;
import com.alf.testtask.dto.FlightResponseDTO;
import com.alf.testtask.dto.FlightRequestDTO;
import com.alf.testtask.dto.PassengerResponseDTO;
import com.alf.testtask.dto.PassengerRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  private final FlightService flightService;

  FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping
  public ResponseEntity<Page<FlightResponseDTO>> getFlights(@PageableDefault(size = 10, sort = "departureTime") Pageable pageable) {
    return ResponseEntity.ok(flightService.getFlights(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<FlightResponseDTO> getFlightById(@PathVariable Long id) {
    return ResponseEntity.ok(flightService.getFlightById(id));
  }

  @PostMapping
  public ResponseEntity<FlightResponseDTO> createFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
    return ResponseEntity.ok(flightService.createFlight(flightRequestDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<FlightResponseDTO> updateFlight(@PathVariable Long id, @RequestBody FlightRequestDTO flightRequestDTO) {
    return ResponseEntity.ok(flightService.updateFlight(id, flightRequestDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
    flightService.deleteFlight(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}/passengers")
  public ResponseEntity<List<PassengerResponseDTO>> getPassengersByFlightId(@PathVariable Long id) {
    return ResponseEntity.ok(flightService.getPassengersByFlightId(id));
  }

  @PostMapping("/{id}/passengers")
  public ResponseEntity<PassengerResponseDTO> addPassengerToFlight(@PathVariable Long id, @RequestBody PassengerRequestDTO passengerRequestDTO) {
    return ResponseEntity.ok(flightService.addPassengerToFlight(id, passengerRequestDTO));
  }
}
