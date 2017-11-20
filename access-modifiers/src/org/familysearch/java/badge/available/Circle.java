package org.familysearch.java.badge.available;

public class Circle extends Shape {
  int radius;

  // this works because this Circle is in the same package as Shape
  @Override
  void defaultAccess() {
    System.out.println("defaultAccess method on an instance of available.Circle from package 'available' called!");
  }
}
