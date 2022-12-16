package com.auto.autobknd.entities;

import static java.util.Objects.nonNull;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.enums.CarType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Car {

  @Id
  private String id;

  private String name;
  private String color;
  private Double price;
  private CarType type;

  public Car(CarDto carDto) {
    this.name = carDto.getName();
    this.color = carDto.getColor();
    this.price = carDto.getPrice();
    this.type = carDto.getType();
  }
}

