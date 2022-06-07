package com.fengyi.javastream;


import com.fengyi.javastream.functionalInterface.EvenChecker;
import com.fengyi.javastream.functionalInterface.MonsterConsumer;
import com.fengyi.javastream.functionalInterface.SalarySupplier;
import com.fengyi.javastream.functionalInterface.StringConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
@ExtendWith(OutputCaptureExtension.class)
public class FunctionalInterfaceIntroduction {

  @Test
  void learn_about_function() {
    assertEquals("1", new StringConverter().apply(1));
  }

  @Test
  void learn_about_predicate() {
    assertFalse(new EvenChecker().test(3));
  }

  @Test
  void learn_about_consumer(CapturedOutput capturedOutput) {
    new MonsterConsumer().accept("elephant");
    assertThat(capturedOutput.toString()).contains("I swallow a elephant");
  }

  @Test
  void learn_about_supplier() {
    assertEquals(BigDecimal.valueOf(10000), new SalarySupplier().get());
  }
}
