package com.fengyi.javastream.functionalInterface;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class MonsterConsumer implements Consumer<String> {

  @Override
  public void accept(String s) {
      log.info("I swallow a {} ", s);
  }
}
