package com.example.cardealer.car;

import static com.example.cardealer.car.CarFactoryFaker.getValidCarEntity;
import static com.example.cardealer.car.CarFactoryFaker.getValidCarRequestDto;
import static com.example.cardealer.car.CarFactoryFaker.getValidCarResponseDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarMapperTest {

  @Test
  void shouldMapRequestDtoToEntity() {
    CarRequestDTO carRequestDto = getValidCarRequestDto();
    Car carEntity = carRequestDto.toEntity();
    assertEquals(carRequestDto.getBrand(), carEntity.getBrand());
    assertEquals(carRequestDto.getModel(), carEntity.getModel());
    assertEquals(carRequestDto.getPrice(), carEntity.getPrice());
  }

  @Test
  void shouldMapEntityToResponseDto() {
    Car carEntity = getValidCarEntity();
    CarResponseDTO carResponseDto = carEntity.toResponseDto();
    assertEquals(carEntity.getBrand(), carResponseDto.getBrand());
    assertEquals(carEntity.getModel(), carResponseDto.getModel());
    assertEquals(carEntity.getPrice(), carResponseDto.getPrice());
  }

  @Test
  void shouldMapResponseDtoToRequestDto() {
    CarResponseDTO carResponseDto = getValidCarResponseDto();
    CarRequestDTO carRequestDto = carResponseDto.toRequestDto();
    assertEquals(carResponseDto.getBrand(), carRequestDto.getBrand());
    assertEquals(carResponseDto.getModel(), carRequestDto.getModel());
    assertEquals(carResponseDto.getPrice(), carRequestDto.getPrice());
  }
}