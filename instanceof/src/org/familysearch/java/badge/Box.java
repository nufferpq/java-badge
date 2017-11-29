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

  @Override
  public String toString() {
    return dumpBox();
  }
}