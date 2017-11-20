package org.familysearch.java.badge;

import java.io.IOException;
    import java.io.RandomAccessFile;

public class SimpleTextFile implements Commentable {
  static RandomAccessFile randomAccessFile;
  static int commentCount;

  public SimpleTextFile(String fileName) throws IOException {
    randomAccessFile = new RandomAccessFile(fileName, "rw");
    commentCount = 0;
  }
  public static void close() throws IOException{
    randomAccessFile.close();
  }
  public static void append(String text) throws IOException{
    randomAccessFile.seek(randomAccessFile.length());
    randomAccessFile.writeBytes(text);
    if (!text.endsWith("\n")) {
      randomAccessFile.writeBytes("\n");
    }
  }

  public static int getCommentCount() {
    return commentCount++;
  }

  @Override
  public void appendComment(String comment) throws IOException {
    append(";" + comment + " " + commentCount++);
  }
}