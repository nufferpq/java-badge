package org.familysearch.java.badge.available;

public class Shape {

  void defaultAccess(){
    System.out.println("defaultAccess method on an instance of Shape called!");
  }
  private void privateAccess(){
    System.out.println("privateAccess method on an instance of Shape called!");
  }
  protected void protectedAccess(){
    System.out.println("protectedAccess method on an instance of Shape called!");
  }
  public void publicAccess(){
    System.out.println("publicAccess method on an instance of Shape called!");
  }
}
