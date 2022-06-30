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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
  void function_anonymous_inner_class() {
    Function<Integer, String> stringConverter = new Function<Integer, String>() {
      @Override
      public String apply(Integer integer) {
        return String.valueOf(integer);
      }
    };
    assertEquals("1", stringConverter.apply(1));
  }

  @Test
  void function_lambda() {
    Function<Integer, String> stringConverter = (integer) -> String.valueOf(integer);
    assertEquals("1", stringConverter.apply(1));
  }

  @Test
  void function_lambda_to_method_reference() {
    Function<Integer, String> stringConverter = String::valueOf;
    assertEquals("1", stringConverter.apply(1));
  }

  @Test
  void learn_about_predicate() {
    assertFalse(new EvenChecker().test(3));
  }

  @Test
  void predicate_anonymous_inner_class() {
    Predicate<Integer> evenChecker = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 0;
      }
    };
    assertFalse(evenChecker.test(3));
  }

  @Test
  void predicate_lambda() {
    Predicate<Integer> evenChecker = integer -> integer % 2 == 0;
    assertFalse(evenChecker.test(3));
  }

  @Test
  void learn_about_consumer(CapturedOutput capturedOutput) {
    new MonsterConsumer().accept("elephant");
    assertThat(capturedOutput.toString()).contains("I swallow a elephant");
  }

  @Test
  void consumer_anonymous_inner_class(CapturedOutput capturedOutput) {
    Consumer<String> monsterConsumer = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.printf("I swallow a %s ", s);
      }
    };
    monsterConsumer.accept("elephant");
    assertThat(capturedOutput.toString()).contains("I swallow a elephant");
  }

  @Test
  void consumer_lambda(CapturedOutput capturedOutput) {
    Consumer<String> monsterConsumer = (String s) -> System.out.printf("I swallow a %s ", s);
    monsterConsumer.accept("elephant");
    assertThat(capturedOutput.toString()).contains("I swallow a elephant");
  }

  @Test
  void learn_about_supplier() {
    assertEquals(BigDecimal.valueOf(10000), new SalarySupplier().get());
  }

  @Test
  void supplier_anonymous_inner_class() {

    Supplier<BigDecimal> salarySupplier = new Supplier<BigDecimal>() {
      @Override
      public BigDecimal get() {
        return BigDecimal.valueOf(10000);
      }
    };
    assertEquals(BigDecimal.valueOf(10000), salarySupplier.get());
  }

  @Test
  void supplier_lambda() {
    Supplier<BigDecimal> salarySupplier = () -> BigDecimal.valueOf(10000);
    assertEquals(BigDecimal.valueOf(10000), salarySupplier.get());
  }
}
