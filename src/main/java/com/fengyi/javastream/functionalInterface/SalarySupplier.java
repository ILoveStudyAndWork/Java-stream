package com.fengyi.javastream.functionalInterface;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class SalarySupplier implements Supplier<BigDecimal> {
  @Override
  public BigDecimal get() {
    return BigDecimal.valueOf(10000);
  }
}
