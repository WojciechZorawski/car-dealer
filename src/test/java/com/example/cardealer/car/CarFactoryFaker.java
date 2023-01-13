package com.example.cardealer.car;

import com.example.cardealer.brokerage.Brokerage;
import com.github.javafaker.Faker;
import java.util.Random;

public class CarFactoryFaker {

  private static final Faker FAKER = Faker.instance(new Random(81));

  private static Brokerage brokerage;

  public static Car toEntity(CarRequestDTO requestDto) {
    return Car.builder()
              .brand(requestDto.getBrand())
              .model(requestDto.getModel())
              .price(requestDto.getPrice())
              .brokerage(brokerage.calculateBrokerage(requestDto.getPrice()))
              .build();
  }

  public static CarResponseDTO toResponseDto(CarRequestDTO requestDto) {
    return CarResponseDTO.builder()
                         .brand(requestDto.getBrand())
                         .model(requestDto.getModel())
                         .price(requestDto.getPrice())
                         .brokerage(brokerage.calculateBrokerage(requestDto.getPrice()))
                         .build();
  }

  public static Car getValidCarEntity() {
    String brand = FAKER.name().name();
    return Car.builder()
              .id(1L)
              .brand(brand)
              .model(FAKER.name().lastName())
              .price(53021L)
              .brokerage(brokerage.calculateBrokerage(53021L))
              .build();
  }

  public static CarResponseDTO getValidCarResponseDto() {
    String brand = FAKER.name().name();
    return CarResponseDTO.builder()
                         .brand(brand)
                         .model(FAKER.name().lastName())
                         .price(4210L)
                         .brokerage(brokerage.calculateBrokerage(4210L))
                         .build();
  }

  public static CarRequestDTO getValidCarRequestDto() {
    return CarRequestDTO.builder()
                        .brand(FAKER.name().name())
                        .model(FAKER.name().lastName())
                        .price(9999L)
                        .build();
  }
}