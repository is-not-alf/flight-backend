package com.alf.testtask.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.alf.testtask.mapper.AircraftMapper;
import com.alf.testtask.dto.AircraftResponseDTO;
import com.alf.testtask.repository.AircraftRepository;

@Service
@RequiredArgsConstructor
public class AircraftService {
  private final AircraftRepository aircraftRepository;
  private final AircraftMapper aircraftMapper;

  public List<AircraftResponseDTO> getAircrafts() {
    return aircraftRepository.findAll().stream()
      .map(aircraftMapper::toResponseDto)
      .collect(Collectors.toList());
  }
  
}
