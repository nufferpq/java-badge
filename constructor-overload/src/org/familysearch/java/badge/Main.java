package org.familysearch.java.badge;

public class Main {
  public static void main(String[] args) {
    Box box1 = new Box();
    System.out.println(box1.dumpBox());

    Box box2 = new Box(2);
    System.out.println(box2.dumpBox());

    Box box3 = new Box("Box Three");
    System.out.println(box3.dumpBox());

    Box box4 = new Box(4);
    System.out.println(box4.dumpBox());

    Box box5 = new Box(5, 5, 5);
    System.out.println(box5.dumpBox());

    Box box6 = new Box(6, 6);
    System.out.println(box6.dumpBox());

    Box box7 = new Box(7, 7, 7, 7, 7, "Box Seven");
    System.out.println(box7.dumpBox("-- Box Seven Dump --"));

  }
}
