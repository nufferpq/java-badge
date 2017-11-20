package org.familysearch.java.badge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    System.out.println("Throw a checked exception...");
    try{
      FileReader file = new FileReader("test.txt");
      BufferedReader fileInput = new BufferedReader(file);

      for (int counter = 0; counter < 3; counter++)
        System.out.println(fileInput.readLine());

      fileInput.close();
    } catch (IOException e){
        System.out.println("\tCaught checked exception: " + e.getClass() + " with message: \"" + e.getMessage() + "\"");
    }

    System.out.println("Throw an unchecked exception...");
    try {
      String line = null;
      line.compareTo("test");
    } catch (NullPointerException e){
      System.out.println("\tCaught unchecked exception: " + e.getClass() + " with message: \"" + e.getMessage() + "\"");
    }

    System.out.println("Throw another unchecked exception...");
    try {
      int[] data = new int[] { 0, 0, 0 };
      System.out.println("4th Element: " + data[3]);
    } catch (ArrayIndexOutOfBoundsException e){
       System.out.println("\tCaught unchecked exception:" + e.getClass() + " with message: \"" + e.getMessage() + "\"");
    }

    System.out.println("Throw another unchecked exception...");
    try {
      System.out.println("Show divide by zero: " + 3/0);
    } catch (ArithmeticException e){
      System.out.println("\tCaught unchecked exception: " + e.getClass() + " with message: \"" + e.getMessage() + "\"");
    }

    System.out.println("Throw an error...");
    String myCharacters = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";
    ArrayList<String> stringArrayList = new ArrayList<String>();

    try {
      // allocate space for a string that will later 'go out of scope' and allow for assembling a string to print an error.
      String tempStr = new String(myCharacters + myCharacters + myCharacters + myCharacters);
      // add elements to a list until memory is exhausted.
      while (true) {
        stringArrayList.add(new String(myCharacters));
      }
    }
    catch (OutOfMemoryError e) {
      System.out.println("\tCaught Error: " + e.getClass() + " with message: \"" + e.getMessage() + "\"");
    }

  }
}
