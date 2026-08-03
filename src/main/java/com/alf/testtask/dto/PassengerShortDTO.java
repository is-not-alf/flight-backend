package com.alf.testtask.dto;

public record PassengerShortDTO(
    Long id,
    String firstName,
    String lastName,
    String passportNumber
) {}
