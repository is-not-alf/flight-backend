package com.alf.testtask.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public record FlightResponseDTO(
  Long id,
  String flightNumber,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  LocalDateTime departureTime,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  LocalDateTime arrivalTime,
  AirportResponseDTO departureAirport,
  AirportResponseDTO arrivalAirport,
  AircraftResponseDTO aircraft,
  List<PassengerShortDTO> passengers
) {}