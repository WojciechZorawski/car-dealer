package com.example.cardealer.car;

import com.example.cardealer.brokerage.Brokerage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDTO {

  private String brand;
  private String model;
  private Long price;

  public Car toEntity() {
    return Car.builder()
              .brand(brand)
              .model(model)
              .price(price)
              .brokerage(Brokerage.calculateBrokerage(price))
              .build();
  }
}

