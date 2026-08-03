package com.alf.testtask.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.alf.testtask.service.PassengerService;
import com.alf.testtask.dto.PassengerResponseDTO;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
  private final PassengerService passengerService;

  PassengerController(PassengerService passengerService) {
    this.passengerService = passengerService;
  }

  @GetMapping
  public ResponseEntity<List<PassengerResponseDTO>> getPassengers() {
    return ResponseEntity.ok(passengerService.getPassengers());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
    passengerService.deletePassenger(id);
    return ResponseEntity.noContent().build();
  }
}
