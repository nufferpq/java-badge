package org.familysearch.java.badge;

public enum TimeZonesUS {
  Eastern("E", -5, -4, Coin.PENNY),
  Central("C", -6, -5, Coin.NICKEL),
  Mountain("M", -7, -6, Coin.DIME),
  Pacific("P", -8, -7, Coin.QUARTER),
  Alaska("AK", -9, -8, Coin.FIFTY_CENT),
  Hawaii("HA", -10, -9, Coin.DOLLAR);

  private String abbreviation;
  private int standardOffset;
  private int daylightOffset;
  private Coin tzCoin;

  TimeZonesUS(String abbreviation, int standardOffset, int daylightOffset, Coin tzCoin){
    this.abbreviation=abbreviation;
    this.standardOffset=standardOffset;
    this.daylightOffset=daylightOffset;
    this.tzCoin=tzCoin;
  }

  public int getStandardOffset() {
    return standardOffset;
  }

  public int getDaylightOffset() {
    return daylightOffset;
  }

  public int getOffset(boolean inDst){
    if(inDst){
      return getDaylightOffset();
    } else {
      return getStandardOffset();
    }
  }

  public String getAbbreviation(boolean inDST){
    if(inDST){
      return abbreviation + "DT";
    } else {
      return abbreviation + "ST";
    }
  }

  public int getUtcHour(int tzHour, boolean inDst){
    int offset = getOffset(inDst);
    int uTCHour = tzHour - offset;
    return uTCHour%24;
  }

  public int getTZHour(int utcHour, boolean inDst){
    int offset = getOffset(inDst);
    int tzHour = utcHour + offset;
    while(tzHour<0){
      tzHour=tzHour+24;
    }
    return tzHour%24;
  }

  public Coin getTZCoin() {
    return tzCoin;
  }
  public String toString(){
    return abbreviation + ":" + standardOffset + ":" + daylightOffset + ":" + tzCoin;
  }

  public enum Coin {
    PENNY,
    NICKEL,
    DIME,
    QUARTER,
    FIFTY_CENT,
    DOLLAR
  }

}
