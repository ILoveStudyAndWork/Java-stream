package com.fengyi.javastream.functionalInterface;

import java.util.function.Predicate;

public class EvenChecker implements Predicate<Integer> {

  @Override
  public boolean test(Integer integer) {
    return integer % 2 == 0;
  }
}
