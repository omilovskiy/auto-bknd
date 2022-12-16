package com.auto.autobknd.repositories;

import com.auto.autobknd.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
