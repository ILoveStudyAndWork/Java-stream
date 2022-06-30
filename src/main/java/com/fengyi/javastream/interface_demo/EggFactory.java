package com.fengyi.javastream.interface_demo;

import com.fengyi.javastream.interface_demo.creature.LayEggCreature;

public class EggFactory {
  private LayEggCreature layEggCreature;

  public EggFactory(LayEggCreature layEggCreature) {
    this.layEggCreature = layEggCreature;
  }

  public String produceEgg() {
    String egg = layEggCreature.layEgg();
    System.out.println(egg);
    return egg;
  }
}
