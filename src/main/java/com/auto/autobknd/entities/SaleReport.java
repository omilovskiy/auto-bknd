package com.auto.autobknd.entities;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class SaleReport {

  @Id
  private String id;

  private String sellerId;
  private String carId;
  private Double totalPrice;
}
