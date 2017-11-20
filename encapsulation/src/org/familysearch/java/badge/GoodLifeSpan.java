package org.familysearch.java.badge;

import java.util.Date;

//Good encapsulation is a class that happens to hold a date.
//In the real world it would probably do more than that.
//It is meant to be immutable - hence the lack of a setter for date.
//Unfortunately, date is mutable.
//This is dealt with by calling clone in the constructor and getter.

public class GoodLifeSpan {
  private Date birthDate;
  private Date deathDate;

  public GoodLifeSpan(Date birthDateValue, Date deathDateValue){
    birthDate = (Date)birthDateValue.clone();   // By cloning the date we protect the immutability of this class.
    deathDate = (Date)deathDateValue.clone();
    // Its state won't change even if the passed in date changes after construction.
  }

  public Date getBirthDate() {
    return (Date)(birthDate.clone());    // By returning a cloned date to caller, we are preventing them from modifying
    // the member birth date. thus preserving immutability.
  }

  public Date getDeathDate() {
    return (Date)(deathDate.clone());    // By returning a cloned date to caller, we are preventing them from modifying
    // the member death date. thus preserving immutability.
  }

  public long getLifeSpanInMilliseconds() {
    long lifeSpanInMilliseconds = deathDate.getTime() - birthDate.getTime();
    lifeSpanInMilliseconds = (lifeSpanInMilliseconds < 0) ? 0 : lifeSpanInMilliseconds;
    return lifeSpanInMilliseconds;
  }
}