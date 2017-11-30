package org.familysearch.java.badge;

public class Main {

  public static void main( String[] args ) {
    LogHelper log = new LogHelper(Main.class);

    log.logInfo("Logging Info");
    log.logWarn("Logging Warn");
    log.logError("Logging Error");
    log.logDebug("Logging Debug");

    Cool cool = new Cool();
    cool.coolness("I am so cool!");
  }
}
