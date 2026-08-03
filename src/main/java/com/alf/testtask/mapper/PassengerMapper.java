package com.alf.testtask.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alf.testtask.dto.PassengerRequestDTO;
import com.alf.testtask.dto.PassengerResponseDTO;
import com.alf.testtask.model.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

  @Mapping(target = "flight.id", source = "flightId")
  Passenger toEntity(PassengerRequestDTO passengerRequestDTO);

  PassengerResponseDTO toResponseDto(Passenger passenger);
}
