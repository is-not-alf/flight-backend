package com.alf.testtask.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.alf.testtask.mapper.AirportMapper;
import com.alf.testtask.dto.AirportResponseDTO;
import com.alf.testtask.repository.AirportRepository;

@Service
@RequiredArgsConstructor
public class AirportService {
  private final AirportRepository airportRepository;
  private final AirportMapper airportMapper;

  public List<AirportResponseDTO> getAirports() {
    return airportRepository.findAll().stream()
      .map(airportMapper::toResponseDto)
      .collect(Collectors.toList());
  }
}
