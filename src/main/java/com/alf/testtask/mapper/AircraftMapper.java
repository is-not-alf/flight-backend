package com.alf.testtask.mapper;

import org.mapstruct.Mapper;

import com.alf.testtask.dto.AircraftResponseDTO;
import com.alf.testtask.model.Aircraft;

@Mapper(componentModel = "spring")
public interface AircraftMapper {
  AircraftResponseDTO toResponseDto(Aircraft aircraft);
  
}
