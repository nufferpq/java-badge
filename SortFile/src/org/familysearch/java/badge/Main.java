package org.familysearch.java.badge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

  private static String fileLocation = "/Users/nufferpq/Sandbox/java-badge/SortFile/src/org/familysearch/java/badge/";

  public static void main(String[] args) {
    try {
      sortFile2();
    }
    catch (Exception e) {
      System.out.println("Exception caught!");
      System.out.println("Exception Message: " + e.getMessage());
      System.out.println("Exception Cause Message: " + e.getCause().getMessage());
      System.out.println("Exception StackTrace: " + e.getCause().getStackTrace().toString());
      System.out.print("Exception printStackTrace: ");
      e.printStackTrace();
    }
  }

  public static void sortFile() throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(fileLocation + "lorem.txt"));
    Map<String, String> map=new TreeMap<String, String>();
    String line="";
    while((line=reader.readLine())!=null){
      map.put(getField(line),line);
    }
    reader.close();
    FileWriter writer = new FileWriter(fileLocation + "lorem.out.txt");
    for(String val : map.values()){
      writer.write(val);
      writer.write('\n');
    }
    writer.close();
  }

  public static void sortFile2() throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(fileLocation + "lorem.txt"));
    ArrayList<String> arrayList=new ArrayList();
    String line="";
    while((line=reader.readLine())!=null){
      arrayList.add(line);
    }
    reader.close();

    Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);

    FileWriter writer = new FileWriter(fileLocation + "lorem.out.txt");
    for(String val : arrayList){
      writer.write(val);
      writer.write('\n');
    }
    writer.close();
  }

  private static String getField(String line) {
    return line.split(" ")[0]; //extract value you want to sort on
  }

}
