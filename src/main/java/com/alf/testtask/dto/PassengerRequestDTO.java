package com.alf.testtask.dto;

public record PassengerRequestDTO(
  Long id, 
  Long flightId, 
  String firstName, 
  String lastName, 
  String passportNumber
) {}
