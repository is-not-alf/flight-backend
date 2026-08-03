package com.alf.testtask.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record FlightRequestDTO(
  Long id,
  String flightNumber,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  LocalDateTime departureTime,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  LocalDateTime arrivalTime,
  Long departureAirportId,
  Long arrivalAirportId,
  Long aircraftId
) {}
