package org.familysearch.java.badge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {
    showMemory();
    outOfMemoryErrorTest1();
    System.gc();
    outOfMemoryErrorTest2();
    System.gc();
    outOfMemoryErrorTest3();
  }

  public static void outOfMemoryErrorTest1() {
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

  public static void outOfMemoryErrorTest2() {
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
      e2.printStackTrace();
    }
  }

  public static void outOfMemoryErrorTest3() {
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
      e2.printStackTrace();
    }

  }

  public static void showMemory() {
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
