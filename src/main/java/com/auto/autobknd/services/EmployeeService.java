package com.auto.autobknd.services;

import static java.util.Objects.nonNull;

import com.auto.autobknd.dto.CarDto;
import com.auto.autobknd.dto.EmployeeDto;
import com.auto.autobknd.entities.Car;
import com.auto.autobknd.entities.Employee;
import com.auto.autobknd.exceptions.NotFoundException;
import com.auto.autobknd.repositories.CarRepository;
import com.auto.autobknd.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public Employee upsert(EmployeeDto employeeDto) {
    Employee employee = new Employee(employeeDto);

    if (nonNull(employeeDto.getId())) {
      Employee existingEmployee = getById(employeeDto.getId());
      employee.setId(existingEmployee.getId());
    }

    return employeeRepository.save(employee);
  }

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee getById(String id) {
    return findById(id).orElseThrow(() -> new NotFoundException("Can't find by id: " + id));
  }

  public Optional<Employee> findById(String id) {
    return employeeRepository.findById(id);
  }
}
