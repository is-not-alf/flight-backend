package com.alf.testtask.mapper;

import org.mapstruct.Mapper;

import com.alf.testtask.dto.AirportResponseDTO;
import com.alf.testtask.model.Airport;

@Mapper(componentModel = "spring")
public interface AirportMapper {
  AirportResponseDTO toResponseDto(Airport airport);
}
