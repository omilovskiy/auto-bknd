package com.auto.autobknd.controllers;

import com.auto.autobknd.dto.EmployeeDto;
import com.auto.autobknd.dto.HttpResponse;
import com.auto.autobknd.dto.SaleReportDto;
import com.auto.autobknd.entities.Employee;
import com.auto.autobknd.entities.SaleReport;
import com.auto.autobknd.services.EmployeeService;
import com.auto.autobknd.services.SaleReportService;
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
@RequestMapping("/sale-reports")
@RequiredArgsConstructor
public class SaleReportController {

  private final SaleReportService saleReportService;

  @PostMapping
  public SaleReport upsert(@RequestBody SaleReportDto saleReportDto) {
    return saleReportService.save(saleReportDto);
  }

  @GetMapping
  public List<SaleReport> getAll() {
    return saleReportService.findAll();
  }

  @DeleteMapping("/{id}")
  public HttpResponse delete(@PathVariable String id) {
    saleReportService.deleteById(id);
    return new HttpResponse("Success");
  }
}
