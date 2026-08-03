package com.alf.testtask.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import jakarta.transaction.Transactional;

import com.alf.testtask.mapper.PassengerMapper;
import com.alf.testtask.dto.PassengerResponseDTO;
import com.alf.testtask.repository.PassengerRepository;
import com.alf.testtask.model.Passenger;

@Service
@RequiredArgsConstructor
public class PassengerService {
  private final PassengerRepository passengerRepository;
  private final PassengerMapper passengerMapper;

  public List<PassengerResponseDTO> getPassengers() {
    return passengerRepository.findAll().stream()
      .map(passengerMapper::toResponseDto)
      .collect(Collectors.toList());
  }
  
  @Transactional
  public void deletePassenger(Long id) {
    Passenger passenger = passengerRepository.findById(id).orElse(null);
    if (passenger == null) {
      throw new RuntimeException("При удалении пассажира произошла ошибка, не найден пассажир");
    }
    passengerRepository.deleteById(id);
  }
}
