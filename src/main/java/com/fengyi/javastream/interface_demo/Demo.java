package com.fengyi.javastream.interface_demo;

import com.fengyi.javastream.interface_demo.creature.Chicken;
import com.fengyi.javastream.interface_demo.creature.Duck;
import com.fengyi.javastream.interface_demo.creature.LayEggCreature;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
  public static void main(String[] args) {
    LayEggCreature chicken = new Chicken();
    LayEggCreature duck = new Duck();
    new EggFactory(chicken).produceEgg();
    new EggFactory(duck).produceEgg();
  }
}
