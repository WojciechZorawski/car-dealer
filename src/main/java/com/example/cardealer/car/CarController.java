package com.example.cardealer.car;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

  private final CarService carService;

  @PostMapping
  public CarResponseDTO createCar(@RequestBody final CarRequestDTO newCar) {
    CarResponseDTO createdCar = carService.createCar(newCar);
    return createdCar;
  }
}