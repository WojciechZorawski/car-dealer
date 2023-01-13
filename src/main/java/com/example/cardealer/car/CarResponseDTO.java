package com.example.cardealer.car;

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
public class CarResponseDTO {

  private String brand;
  private String model;
  private Long price;
  private double brokerage;

  public CarRequestDTO toRequestDto() {
    return CarRequestDTO.builder()
                        .brand(brand)
                        .model(model)
                        .price(price)
                        .build();
  }
}
