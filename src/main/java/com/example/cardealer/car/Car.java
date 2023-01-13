package com.example.cardealer.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private String model;
  private Long price;
  private double brokerage;

  public CarResponseDTO toResponseDto() {
    return CarResponseDTO.builder()
                         .brand(brand)
                         .model(model)
                         .price(price)
                         .brokerage(brokerage)
                         .build();
  }
}
