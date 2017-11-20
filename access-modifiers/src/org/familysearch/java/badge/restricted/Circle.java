package org.familysearch.java.badge.restricted;

import org.familysearch.java.badge.available.Shape;

public class Circle extends Shape {

//    This will not compile because Shape is in package 'available' so Circle in package 'restricted' cannot override methods
//       with default access in a different package.

//  @Override
  void defaultAccess() {
    System.out.println("defaultAccess method on an instance of restricted.Circle from package 'restricted' called!");
  }

  private void privateAccess(){
    System.out.println("privateAccess method on an instance of restricted.Circle from package 'restricted' called!");
  }

  @Override
  protected void protectedAccess() {
    System.out.println("protectedAccess method on an instance of restricted.Circle from package 'restricted' called!");
  }

  @Override
  public void publicAccess(){
    System.out.println("publicAccess method on an instance of restricted.Circle from package 'restricted' called!");
  }

}
