package org.familysearch.java.badge;

public class Main {

  public static void main(String[] args) {
    System.out.println(TimeZonesUS.Eastern.name() + "= " + TimeZonesUS.Eastern.toString());
    System.out.println(TimeZonesUS.Central.name() + "= " + TimeZonesUS.Central.toString());
    System.out.println(TimeZonesUS.Mountain.name() + "= " + TimeZonesUS.Mountain.toString());
    System.out.println(TimeZonesUS.Pacific.name() + "= " + TimeZonesUS.Pacific.toString());
    System.out.println(TimeZonesUS.Alaska.name() + "= " + TimeZonesUS.Alaska.toString());
    System.out.println(TimeZonesUS.Hawaii.name() + "= " + TimeZonesUS.Hawaii.toString());
    ZonedTime zonedTime1 = new ZonedTime(8, 12, 34, TimeZonesUS.Hawaii, true);
    System.out.println("TimeZone: " + zonedTime1.toString());
    ZonedTime zonedTime2 = new ZonedTime(4, 12, 34, TimeZonesUS.Pacific, true);
    System.out.println("TimeZone: " + zonedTime2.toString());
  }
}
