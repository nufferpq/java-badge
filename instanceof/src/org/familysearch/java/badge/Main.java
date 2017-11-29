package org.familysearch.java.badge;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    displayObject(121);
    displayObject(new Integer(291));
    displayObject("Today is your lucky day!");
    displayObject(true);
    displayObject(new Boolean(false));
    displayObject(new Boolean(null));
    displayObject(Math.PI);
    int[] data = {1,2,3,5,8,13};
    displayObject(data);
    Integer[] integerArray = {1,2,3,5,8,13};
    displayObject(integerArray);
    String[] strArray = {"one","two","three","five","eight","thirteen"};
    displayObject(strArray);
    List<String> strList = Arrays.asList(strArray);
    displayObject(strList);
    displayObject(new Box(2,3,4, 1, 4, "TestBoxObject"));
  }

  public static void displayObject(Object object) {
    if (object instanceof Integer) {
      Integer integer = (Integer)object;
      System.out.println("Object is an Integer with value of: " + integer);
    }
    if (object instanceof int[]) {
      int[] intArray = (int[])object;
      System.out.println("Object is an int[] with value of: " + dumpIntArray(intArray));
    }
    else if (object instanceof String) {
      String str = (String)object;
      System.out.println("Object is a String with value of: " + str);
    }
    else if (object instanceof Boolean) {
      Boolean bool = (Boolean)object;
      System.out.println("Object is a Boolean with value of: " + bool);
    }
    else if (object instanceof Box) {
      Box box = (Box)object;
      System.out.println("Object is a Box with value of: " + box.dumpBox());
    }
    else {
      System.out.println("Object is a " + object.getClass().getSimpleName() + " with a value of: " + object.toString());
    }
  }

  public static String dumpIntArray(int[] intArray) {
    String returnStr = "";
    for (int value : intArray) {
      returnStr += String.valueOf(value) + ", ";
    }
    return returnStr;
  }
}
