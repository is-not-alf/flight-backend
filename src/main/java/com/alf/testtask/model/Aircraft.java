package com.alf.testtask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aircrafts")
@Getter
@Setter
public class Aircraft {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "model")
  private String model;

  @Column(name = "capacity")
  private int capacity;
}
