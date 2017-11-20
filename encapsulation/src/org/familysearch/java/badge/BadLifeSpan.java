package org.familysearch.java.badge;

import java.util.Date;

// This class is intended to be immutable so it doesn't have a setter for date.
// Unfortunately, java.util.Date is mutable so outside users of this class may make inadvertent modifications...

public class BadLifeSpan {
  private Date birthDate;
  private Date deathDate;

  public BadLifeSpan(Date birthDateValue, Date deathDateValue){
    this.birthDate = birthDateValue;   // This is bad because the caller of the constructor may modify the passed in date,
    this.deathDate = deathDateValue;   // This is bad because the caller of the constructor may modify the passed in date,
    // thus modifying the state of this class which is supposed to be immutable.
  }

  public Date getBirthDate() {
    return birthDate;    // This is bad because the caller of this method may modify the returned date,
    // thus modifying the state of this class which is supposed to be immutable.
  }
  public Date getDeathDate() {
    return deathDate;    // This is bad because the caller of this method may modify the returned date,
    // thus modifying the state of this class which is supposed to be immutable.
  }

  public long getLifeSpanInMilliseconds() {
    long lifeSpanInMilliseconds = deathDate.getTime() - birthDate.getTime();
    lifeSpanInMilliseconds = (lifeSpanInMilliseconds < 0) ? 0 : lifeSpanInMilliseconds;
    return lifeSpanInMilliseconds;
  }
}