package com.alf.testtask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@Getter
@Setter
public class Passenger {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "passport_number")
  private String passportNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "flight_id", nullable = false)
  private Flight flight;
}
