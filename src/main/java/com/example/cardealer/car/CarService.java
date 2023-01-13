package com.example.cardealer.car;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  public CarResponseDTO createCar(@Valid final CarRequestDTO newCar) {
    Car carEntity = newCar.toEntity();
    Car save = createCarEntity(carEntity);
    return save.toResponseDto();
  }

  public Car createCarEntity(Car carEntity) {
    Car save = carRepository.save(carEntity);
    return save;
  }
}
