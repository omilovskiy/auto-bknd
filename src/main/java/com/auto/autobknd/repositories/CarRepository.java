package com.auto.autobknd.repositories;

import com.auto.autobknd.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {

}
