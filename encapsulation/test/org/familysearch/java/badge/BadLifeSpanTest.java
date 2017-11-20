package org.familysearch.java.badge;

import java.util.Date;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BadLifeSpanTest {

  public static final long DAY_IN_MILLISECONDS = 1000*60*60*24;

  @Test
  public void testBadImmutability() {
    Date birth = new Date();
    Date death = new Date();
    BadLifeSpan badLifeSpan = new BadLifeSpan(birth, death);

    // save the birth and death dates as strings
    String birthResult1 = badLifeSpan.getBirthDate().toString();
    String deathResult1 = badLifeSpan.getDeathDate().toString();
    // ensure they are the same as the original birth and death dates
    assertEquals(birthResult1, birth.toString());
    assertEquals(deathResult1, death.toString());

    // get the dates from the BadLifeSpan object and change the retrieved date.
    Date tempBirthDate = badLifeSpan.getBirthDate();
    tempBirthDate.setTime(tempBirthDate.getTime() - DAY_IN_MILLISECONDS); // born one day earlier
    Date tempDeathDate = badLifeSpan.getDeathDate();
    tempDeathDate.setTime(tempDeathDate.getTime() + DAY_IN_MILLISECONDS); // died one day later

    // show the BadLifeSpan dates do not match the original dates
    assertNotEquals(birthResult1, badLifeSpan.getBirthDate().toString());
    assertNotEquals(deathResult1, badLifeSpan.getDeathDate().toString());
  }

}