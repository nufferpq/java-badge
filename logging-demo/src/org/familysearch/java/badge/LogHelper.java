package org.familysearch.java.badge;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {

  private Logger slf4jLogger;
  private final String ipAddress = getIPAddress();
  private final String hostName = getHostName();
  private final String threadLabel = getThreadLabel();

  LogHelper(Class clazz) {
    slf4jLogger = LoggerFactory.getLogger(clazz);
  }

  // got this from http://stackoverflow.com/questions/7348711/recommended-way-to-get-hostname-in-java
  private String getHostName(){
    String hostName;
    try {
      hostName = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException e){
      hostName = null;
    }
    return hostName;
  }

  // got this code from http://stackoverflow.com/questions/8083479/java-getting-my-ip-address
  private String getIPAddress(){
    String ip=null;
    try {
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
        NetworkInterface iface = interfaces.nextElement();
        // filters out 127.0.0.1 and inactive interfaces
        if (iface.isLoopback() || !iface.isUp())
          continue;

        Enumeration<InetAddress> addresses = iface.getInetAddresses();
        while(addresses.hasMoreElements()) {
          InetAddress addr = addresses.nextElement();
          ip = addr.getHostAddress();
          System.out.println(iface.getDisplayName() + " " + ip);
        }
      }
    } catch (SocketException e) {
      ip = null;
    }
    return ip;
  }

  private String getThreadLabel() {
    return Thread.currentThread().getName() + " [id=" + Thread.currentThread().getId() + "] [priority=" + Thread.currentThread().getPriority() + "]";
  }

  public void logInfo(String message){
    slf4jLogger.info("timestamp=\"{}\" hostname=\"{}\" ip=\"{}\" message=\"{}\"", new Date(), hostName, ipAddress, message);
  }

  public void logWarn(String message){
    slf4jLogger.warn("timestamp=\"{}\" hostname=\"{}\" ip=\"{}\" message=\"{}\"", new Date(), hostName, ipAddress, message);
  }

  public void logError(String message){
    slf4jLogger.error("timestamp=\"{}\" hostname=\"{}\" ip=\"{}\" message=\"{}\"", new Date(), hostName, ipAddress, message);
  }

  public void logDebug(String message){
    slf4jLogger.debug("timestamp=\"{}\" hostname=\"{}\" ip=\"{}\" message=\"{}\"", new Date(), hostName, ipAddress, message);
  }

}
