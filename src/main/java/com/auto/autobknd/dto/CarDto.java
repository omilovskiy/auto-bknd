package com.auto.autobknd.dto;

import com.auto.autobknd.enums.CarType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

  private String id;

  @NotNull private String name;
  @NotNull private String color;
  @NotNull private Double price;
  @NotNull private CarType type;
}
