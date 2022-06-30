package com.fengyi.javastream.interface_demo.creature;

public class Chicken implements LayEggCreature {
  @Override
  public String layEgg() {
    return String.format("%s egg", this.getClass().getSimpleName());
  }
}
