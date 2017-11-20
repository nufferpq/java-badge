package org.familysearch.java.badge;


import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

interface Car {
  int topSpeed(int enginePistonCount);
}

class VWVan implements Car {
  public Date lastOilChange() {
    return new Date("24 November 2016");
  }

  public int topSpeed(int pistonCount) {
    return 22 * pistonCount;
  }
}

class Delorean implements Car {

  public int topSpeed(int pistonCount) {
    return 33 * pistonCount;
  }

  public int topSpeed(int pistonCount, int transmissionGearCount) {
    return 33 * pistonCount * transmissionGearCount ;
  }
}

public class Main {

  public static void main(String[] args) {
    Car car1 = new VWVan();
    Car car2 = new Delorean();

    System.out.println("Vehicle1 topSpeed=" + car1.topSpeed(1));
//    System.out.println("Van lastOilChange=" + car1.lastOilChange());
    System.out.println("Vehicle2 topSpeed=" + car2.topSpeed(12));
  }
}
