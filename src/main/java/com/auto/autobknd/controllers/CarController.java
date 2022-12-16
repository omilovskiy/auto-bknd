package com.auto.autobknd.controllers;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.entities.Car;
import com.auto.autobknd.services.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
  public Car upsert(@RequestBody CarDto userDto) {
    return carService.upsert(userDto);
  }

  @GetMapping
  public List<Car> getAll() {
    return carService.findAll();
  }
}
