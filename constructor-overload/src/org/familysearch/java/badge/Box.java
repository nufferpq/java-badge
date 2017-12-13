package org.familysearch.java.badge;

public class Box {
  double width, height, depth;
  int boxNumber;
  int boxScore;
  String boxLabel = "Blank Box Label";

  Box(double w, double h, double d, int boxNum, int score, String label) {
    width = w;
    height = h;
    depth = d;
    boxNumber = boxNum;
    boxScore = score;
    boxLabel = label;
  }

  Box(double widthValue, double heightValue, double depthValue) {
    width = widthValue;
    height = heightValue;
    depth = depthValue;
  }

  Box() {
    width = height = depth = boxNumber = 0;
    boxLabel = "";
  }

  Box(double len) {
    width = height = depth = len;
  }

  Box(int boxNum, int score) {
    this("CoolBox");
    boxNumber = boxNum;
    boxScore = score;
  }

  Box(String label) {
    this(1);
    boxLabel = label;
  }

  double volume() {
    return width * height * depth;
  }

  int getBoxNumber() {
    return boxNumber;
  }

  String getBoxLabel() {
    return boxLabel;
  }

  String dumpBox() {
    StringBuilder dumpStr = new StringBuilder("-- Box Dump --\n");
    dumpStr.append("| Label: ").append(getBoxLabel()).append("\n");
    dumpStr.append("| Number: ").append(getBoxNumber()).append("\n");
    dumpStr.append("| Score: ").append(boxScore).append("\n");
    dumpStr.append("| Width: ").append(width).append("\n");
    dumpStr.append("| Height: ").append(height).append("\n");
    dumpStr.append("| Depth: ").append(depth).append("\n");
    dumpStr.append("| Volume: ").append(volume()).append("\n");
    dumpStr.append("------------------");
    return dumpStr.toString();
  }

  String dumpBox(String header) {
    StringBuilder dumpStr = new StringBuilder(header + "\n");
    dumpStr.append("| Label: ").append(getBoxLabel()).append("\n");
    dumpStr.append("| Number: ").append(getBoxNumber()).append("\n");
    dumpStr.append("| Score: ").append(boxScore).append("\n");
    dumpStr.append("| Width: ").append(width).append("\n");
    dumpStr.append("| Height: ").append(height).append("\n");
    dumpStr.append("| Depth: ").append(depth).append("\n");
    dumpStr.append("| Volume: ").append(volume()).append("\n");
    dumpStr.append("------------------");
    return dumpStr.toString();
  }


}
