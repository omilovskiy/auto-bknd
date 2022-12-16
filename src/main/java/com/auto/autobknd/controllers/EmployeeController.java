package com.auto.autobknd.controllers;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.dto.EmployeeDto;
import com.auto.autobknd.dto.HttpResponse;
import com.auto.autobknd.entities.Car;
import com.auto.autobknd.entities.Employee;
import com.auto.autobknd.services.CarService;
import com.auto.autobknd.services.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  public Employee upsert(@RequestBody EmployeeDto employeeDto) {
    return employeeService.upsert(employeeDto);
  }

  @GetMapping
  public List<Employee> getAll() {
    return employeeService.findAll();
  }

  @DeleteMapping("/{id}")
  public HttpResponse delete(@PathVariable String id) {
    employeeService.deleteById(id);
    return new HttpResponse("Success");
  }
}
