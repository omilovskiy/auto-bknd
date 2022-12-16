package com.auto.autobknd.entities;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.dto.EmployeeDto;
import com.auto.autobknd.enums.EmployeeTitle;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Employee {

  @Id
  private String id;

  private String firstName;
  private String lastName;
  private EmployeeTitle title;
  private Double salary;

  public Employee(EmployeeDto employeeDto) {
    this.firstName = employeeDto.getFirstName();
    this.lastName = employeeDto.getLastName();
    this.salary = employeeDto.getSalary();
    this.title = employeeDto.getTitle();
  }
}

