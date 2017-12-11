package org.familysearch.java.badge;

public class Cool {
  LogHelper log = new LogHelper(Cool.class);

  public void coolness(String message) {
    log.logError("Coolness = " + message);
  }

}
