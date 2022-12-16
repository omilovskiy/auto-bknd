package com.auto.autobknd.repositories;

import com.auto.autobknd.entities.SaleReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleReportRepository extends MongoRepository<SaleReport, String> {

}
