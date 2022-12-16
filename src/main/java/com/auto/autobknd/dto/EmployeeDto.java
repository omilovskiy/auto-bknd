package com.auto.autobknd.dto;

import com.auto.autobknd.enums.EmployeeTitle;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

  private String id;

  @NotNull private String firstName;
  @NotNull private String lastName;
  @NotNull private EmployeeTitle title;
  @NotNull private Double salary;
}
