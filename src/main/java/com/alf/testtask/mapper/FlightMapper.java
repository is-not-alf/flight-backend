package com.alf.testtask.mapper;

import com.alf.testtask.dto.FlightResponseDTO;
import com.alf.testtask.dto.FlightRequestDTO;
import com.alf.testtask.model.Flight;
import com.alf.testtask.model.Passenger;
import com.alf.testtask.dto.PassengerShortDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FlightMapper {

  @Mapping(target = "departureAirport.id", source = "departureAirportId")
  @Mapping(target = "arrivalAirport.id", source = "arrivalAirportId")
  @Mapping(target = "aircraft.id", source = "aircraftId")
  @Mapping(target = "passengers", ignore = true)
  Flight toEntity(FlightRequestDTO dto);

  FlightResponseDTO toResponseDto(Flight flight);

  @Mapping(target = "departureAirport", ignore = true)
  @Mapping(target = "arrivalAirport", ignore = true)
  @Mapping(target = "aircraft", ignore = true)
  @Mapping(target = "passengers", ignore = true)
  void updateEntityFromDto(FlightRequestDTO dto, @MappingTarget Flight entity);

  PassengerShortDTO toPassengerShortDto(Passenger passenger); 
}
