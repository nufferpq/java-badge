package org.familysearch.java.badge;

import java.util.Date;

interface Vehicle {
  int topSpeed(int enginePistonCount);
}

class VWVan implements Vehicle {
  public Date lastOilChange() {
    return new Date("24 November 2016");
  }

  public int topSpeed(int pistonCount) {
    return 16 * pistonCount;
  }
}

class Delorean implements Vehicle {

  public int topSpeed(int pistonCount) {
    return 29 * pistonCount;
  }
}

public class Main {

  public static void main(String[] args) {
    Vehicle vehicle1 = new VWVan();
    Vehicle vehicle2 = new Delorean();

    System.out.println("Vehicle1 topSpeed=" + vehicle1.topSpeed(4));
//    System.out.println("Van lastOilChange=" + car1.lastOilChange());
    System.out.println("Vehicle2 topSpeed=" + vehicle2.topSpeed(12));
  }
}
