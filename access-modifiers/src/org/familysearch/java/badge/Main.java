package org.familysearch.java.badge;

import org.familysearch.java.badge.available.Circle;
import org.familysearch.java.badge.available.Shape;

public class Main {

  public static void main(String[] args) {
    Shape shape = new Shape();

//  This will fail because Shape is in a different package so methods with default access are not accessable here
//  shape.defaultAccess();

//  This will fail because methods with private access in a different class are not accessable here
//  shape.privateAccess();

//  This will fail because methods with protected access are not accessable unless called from an inheriting class
//  shape.protectedAccess();

    shape.publicAccess();

    Circle circle1 = new Circle();
//    circle1.defaultAccess();  // Circle does not have default access here because it's in a different package
    circle1.publicAccess();

    org.familysearch.java.badge.restricted.Circle circle2 = new org.familysearch.java.badge.restricted.Circle();
//    circle2.defaultAccess();    // cannot access the defaultAccess method of restricted.Circle
//    circle2.privateAccess();    // cannot access the privateAccess method of restricted.Circle
//    circle2.protectedAccess();  // cannot access the protectedAccess method of restricted.Circle
    circle2.publicAccess();
  }


}
