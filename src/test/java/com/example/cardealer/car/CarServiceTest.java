package com.example.cardealer.car;

import static com.example.cardealer.car.CarFactoryFaker.getValidCarEntity;
import static com.example.cardealer.car.CarFactoryFaker.getValidCarRequestDto;
import static com.example.cardealer.car.CarFactoryFaker.toEntity;
import static com.example.cardealer.car.EntityToDtoComparatorHelper.compareCarEntityToCarResponseDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

  @InjectMocks
  private CarService carService;
  @Mock
  private CarRepository carRepository;

  @Test
  void createCarReturnsProperCar() {
    CarRequestDTO requestDto = getValidCarRequestDto();

    when(carRepository.save(any(Car.class))).thenReturn(toEntity(requestDto));

    CarResponseDTO createdCar = carService.createCar(requestDto);
    compareCarEntityToCarResponseDto(toEntity(requestDto), createdCar);
  }

  @Test
  void createCarEntityReturnsProperCar() {
    Car carEntity = getValidCarEntity();

    when(carRepository.save(any(Car.class))).thenReturn(carEntity);

    Car createdCar = carService.createCarEntity(carEntity);
    assertEquals(carEntity.getBrand(), createdCar.getBrand());
    assertEquals(carEntity.getModel(), createdCar.getModel());
    assertEquals(carEntity.getPrice(), createdCar.getPrice());
  }
}
