package com.alf.testtask.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import com.alf.testtask.mapper.FlightMapper;
import com.alf.testtask.mapper.PassengerMapper;
import com.alf.testtask.model.Flight;
import com.alf.testtask.model.Airport;
import com.alf.testtask.model.Aircraft;
import com.alf.testtask.dto.FlightResponseDTO;
import com.alf.testtask.dto.FlightRequestDTO;
import com.alf.testtask.repository.FlightRepository;
import com.alf.testtask.repository.PassengerRepository;
import com.alf.testtask.dto.PassengerResponseDTO;
import com.alf.testtask.dto.PassengerRequestDTO;
import com.alf.testtask.model.Passenger;

@Service
@RequiredArgsConstructor
public class FlightService {

  @PersistenceContext
  private EntityManager entityManager;

  private final FlightRepository flightRepository;
  private final PassengerRepository passengerRepository;
  private final FlightMapper flightMapper;
  private final PassengerMapper passengerMapper;

  public Page<FlightResponseDTO> getFlights(Pageable pageable) {
    Page<Flight> flightPage = flightRepository.findAll(pageable);
    
    return flightPage.map(flightMapper::toResponseDto);
  }

  public FlightResponseDTO getFlightById(Long id) {
    return flightMapper.toResponseDto(flightRepository.findById(id).orElse(null));
  }

  @Transactional
  public FlightResponseDTO createFlight(FlightRequestDTO flightRequestDTO) {
    return flightMapper.toResponseDto(flightRepository.save(flightMapper.toEntity(flightRequestDTO)));
  }

  @Transactional
  public FlightResponseDTO updateFlight(Long id, FlightRequestDTO flightRequestDTO) {
    Flight flight = flightRepository.findById(id).orElse(null);
    if (flight == null) {
      throw new RuntimeException("При сохранении рейса произошла ошибка, не найден рейс");
    }
    flightMapper.updateEntityFromDto(flightRequestDTO, flight);
    flight.setId(id);
    flight.setDepartureAirport(getReferenceOrNull(Airport.class, flightRequestDTO.departureAirportId()));
    flight.setArrivalAirport(getReferenceOrNull(Airport.class, flightRequestDTO.arrivalAirportId()));
    flight.setAircraft(getReferenceOrNull(Aircraft.class, flightRequestDTO.aircraftId()));

    return flightMapper.toResponseDto(flightRepository.save(flight));
  }

  @Transactional
  public void deleteFlight(Long id) {
    Flight flight = flightRepository.findById(id).orElse(null);
    if (flight == null) {
      throw new RuntimeException("При удалении рейса произошла ошибка, не найден рейс");
    }

    flightRepository.deleteById(id);
  }

  public List<PassengerResponseDTO> getPassengersByFlightId(Long id) {
    return passengerRepository.findByFlightId(id).stream()
      .map(passengerMapper::toResponseDto)
      .collect(Collectors.toList());
  }

  @Transactional
  public PassengerResponseDTO addPassengerToFlight(Long id, PassengerRequestDTO passengerRequestDTO) {
    Flight flight = flightRepository.findById(id).orElse(null);
    if (flight == null) {
      throw new RuntimeException("При сохранении пассажира произошла ошибка, не найден рейс");
    }
    Passenger passenger = passengerMapper.toEntity(passengerRequestDTO);
    passenger.setFlight(flight);

    return passengerMapper.toResponseDto(passengerRepository.save(passenger));
  }

  private <T> T getReferenceOrNull(Class<T> entityClass, Long id) {
    return id != null ? entityManager.getReference(entityClass, id) : null;
  }
}
