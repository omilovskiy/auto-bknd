package com.auto.autobknd.services;

import com.auto.autobknd.dto.SaleReportDto;
import com.auto.autobknd.entities.Car;
import com.auto.autobknd.entities.Employee;
import com.auto.autobknd.entities.SaleReport;
import com.auto.autobknd.enums.EmployeeTitle;
import com.auto.autobknd.exceptions.BadRequestException;
import com.auto.autobknd.repositories.SaleReportRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleReportService {

  private static final double EXTRA_PRICE = 1500;

  private final SaleReportRepository saleReportRepository;
  private final CarService carService;
  private final EmployeeService employeeService;

  public SaleReport save(SaleReportDto saleReportDto) {
    SaleReport saleReport = new SaleReport();

    Car carToSale = carService.getById(saleReportDto.getCarId());
    Employee seller = employeeService.getById(saleReportDto.getSellerId());

    if (seller.getTitle() == EmployeeTitle.MECHANIC) {
      throw new BadRequestException("Employee should be with type: Seller");
    }

    saleReport.setCarId(carToSale.getId());
    saleReport.setTotalPrice(carToSale.getPrice() + EXTRA_PRICE);
    saleReport.setSellerId(seller.getId());

    return saleReportRepository.save(saleReport);
  }

  public List<SaleReport> findAll() {
    return saleReportRepository.findAll();
  }
}
