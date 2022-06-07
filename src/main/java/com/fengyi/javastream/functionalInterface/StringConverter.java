package com.fengyi.javastream.functionalInterface;

import java.util.function.Function;

public class StringConverter implements Function<Integer, String> {

  @Override
  public String apply(Integer integer) {
    return String.valueOf(integer);
  }
}
