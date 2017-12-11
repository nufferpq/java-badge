package org.familysearch.java.badge;

import java.util.ArrayList;
import java.util.List;

public class Main {
  static StringBuilder strbldr = new StringBuilder("Adding elements: ");

  public static void main(String[] args) {
    String myString = "0123456789";
    List<String> myStringList = new ArrayList<String>();

    long counter = 0;
    System.out.println("-- out-of-memory program --");
    System.out.println("Begin: Available memory: " + getAvailableMemory());
    System.out.println("Begin: Free memory: " + getFreeMemory());
    try {
      while (true) {
        myStringList.add(myString);
        strbldr.append(counter++ + ",");
      }
    }
    catch (RuntimeException runTimeException) {
      System.out.println("OutOfMemoryError error caught: " + runTimeException.getMessage());
    }
    catch (OutOfMemoryError outOfMemoryError) {
      System.out.println("OutOfMemory error caught: " + outOfMemoryError.getMessage());
    }
    System.out.println("End: Free memory: " + getFreeMemory());
    System.out.println("End: Available memory: " + getAvailableMemory());
//   System.out.println(strbldr.toString());
  }

  private static long getAvailableMemory() {
    Runtime runtime = Runtime.getRuntime();
    long totalMemory = runtime.totalMemory(); // current heap allocated to the VM process
    long freeMemory = runtime.freeMemory(); // out of the current heap, how much is free
    long maxMemory = runtime.maxMemory(); // Max heap VM can use e.g. Xmx setting
    long usedMemory = totalMemory - freeMemory; // how much of the current heap the VM is using
    long availableMemory = maxMemory - usedMemory; // available memory i.e. Maximum heap size minus the current amount used
    return availableMemory;
  }

  private static long getFreeMemory() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.freeMemory(); // out of the current heap, how much is free
  }

}
