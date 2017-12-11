package org.familysearch.java.badge;

import java.util.ArrayList;
import java.util.LinkedList;
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

    showMemory();
    outOfMemoryErrorTest1();
    System.gc();
    outOfMemoryErrorTest2();
    System.gc();
    outOfMemoryErrorTest3();
    System.gc();

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

  private static void outOfMemoryErrorTest1() {
    String myCharacters = "0123456789";
    LinkedList<String> stringArrayList = new LinkedList<String>();
    long itemCount = 0;
    try {
      while (true) {
        stringArrayList.add(myCharacters);
        itemCount++;
      }
    }
    catch (OutOfMemoryError e2) {
      System.out.println("Number of Items in ArrayList: " + itemCount);
      System.out.println("OutOfMemoryError occurred: " + e2.getMessage());
      e2.printStackTrace();
      showMemory();
    }
  }

  private static void outOfMemoryErrorTest2() {
    String myCharacters = "0123456789";
    ArrayList<String> stringArrayList = new ArrayList<String>();
    long itemCount = 0;
    try {
      while (true) {
        stringArrayList.add(new String(myCharacters));
        itemCount++;
      }
    }
    catch (OutOfMemoryError e2) {
      System.out.println("Number of Items in ArrayList: " + itemCount);
      System.out.println("OutOfMemoryError occurred: " + e2.getMessage());
    }
  }

  private static void outOfMemoryErrorTest3() {
    ArrayList<Character> charArrayList = new ArrayList<Character>();
    long itemCount = 0;
    try {
      while (true) {
        charArrayList.add(new Character('1'));
        itemCount++;
      }
    }
    catch (OutOfMemoryError e2) {
      System.out.println("Number of Items in charArrayList: " + itemCount);
      System.out.println("OutOfMemoryError occurred: " + e2.getMessage());
    }

  }

  private static void showMemory() {
    /* Total number of processors or cores available to the JVM */
    System.out.println("Available processors (cores): " +
        Runtime.getRuntime().availableProcessors());

  /* Total amount of free memory available to the JVM */
    System.out.println("Free memory (bytes): " +
        Runtime.getRuntime().freeMemory());

  /* This will return Long.MAX_VALUE if there is no preset limit */
    long maxMemory = Runtime.getRuntime().maxMemory();
  /* Maximum amount of memory the JVM will attempt to use */
    System.out.println("Maximum memory (bytes): " +
        (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

  /* Total memory currently in use by the JVM */
    System.out.println("Total memory (bytes): " +
        Runtime.getRuntime().totalMemory());

    long allocatedMemory =
        (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());

    long presumableFreeMemory = Runtime.getRuntime().maxMemory() - allocatedMemory;

    System.out.println("=====================FreeMemory: " + presumableFreeMemory + " ============================");
  }

}
