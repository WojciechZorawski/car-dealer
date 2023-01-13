package com.example.cardealer.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityToDtoComparatorHelper {

  public static void compareCarEntityToCarResponseDto(Car car, CarResponseDTO carResponseDto) {
    assertEquals(car.getBrand(), carResponseDto.getBrand());
    assertEquals(car.getModel(), carResponseDto.getModel());
    assertEquals(car.getPrice(), carResponseDto.getPrice());
  }
}
