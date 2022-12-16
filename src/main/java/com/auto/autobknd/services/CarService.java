package com.auto.autobknd.services;

import static java.util.Objects.nonNull;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.entities.Car;
import com.auto.autobknd.exceptions.NotFoundException;
import com.auto.autobknd.repositories.CarRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  public Car upsert(CarDto carDto) {
    Car car = new Car(carDto);

    if (nonNull(carDto.getId())) {
      Car existingCar = getById(carDto.getId());
      car.setId(existingCar.getId());
    }

    return carRepository.save(car);
  }

  public List<Car> findAll() {
    return carRepository.findAll();
  }

  public void deleteById(String id) {
    carRepository.deleteById(id);
  }

  public Car getById(String id) {
    return findById(id).orElseThrow(() -> new NotFoundException("Can't find by id: " + id));
  }

  public Optional<Car> findById(String id) {
    return carRepository.findById(id);
  }
}
