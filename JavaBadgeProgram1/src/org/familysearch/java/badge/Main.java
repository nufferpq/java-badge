package org.familysearch.java.badge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  StringBuffer strbldr = new StringBuffer("Adding elements: ");

  public static void main(String[] args) {
    String myString = "0123456789";
    List<String> myStringList = new ArrayList<String>();

    long counter = 0;

    try {
      while (true) {
        myStringList.add(myString);
        strbldr.append(counter++ + ",");
      }
    } catch (RuntimeException runTimeException) {
      System.out.println("OutOfMemoryError error caught: " + runTimeException.getMessage());
    } catch (OutOfMemoryError outOfMemoryError) {
      System.out.println("OutOfMemory error caught: " + outOfMemoryError.getMessage() + ": aldkjfa;lkjfd" + "aldkjfa;lkjfd");
    }
    System.out.println("OutOfMemory program.");
    System.out.println(strbldr.toString());
	// write your code here


  }
}
