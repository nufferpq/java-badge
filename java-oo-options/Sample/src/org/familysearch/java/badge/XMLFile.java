package org.familysearch.java.badge;

import java.io.IOException;

public class XMLFile extends SimpleTextFile implements Commentable {

  public XMLFile(String fileName) throws IOException {
    super(fileName);
  }

  @Override
  public void appendComment(String comment) throws IOException {
    append("<!-- " + comment + " " + getCommentCount() + " -->\n");
  }
}
