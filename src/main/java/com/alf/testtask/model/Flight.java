package com.alf.testtask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "flight_number")
  private String flightNumber;

  @Column(name = "departure_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime departureTime;
  
  @Column(name = "arrival_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime arrivalTime;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "departure_airport_id", nullable = false)
  private Airport departureAirport;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "arrival_airport_id", nullable = false)
  private Airport arrivalAirport;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "aircraft_id", nullable = false)
  private Aircraft aircraft;

  @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Passenger> passengers;
}
