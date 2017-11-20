package org.familysearch.java.badge;

import java.util.Date;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GoodLifeSpanTest {

  public static final long DAY_IN_MILLISECONDS = 1000*60*60*24;

  @Test
  public void testGoodImmutability() {
    Date birth = new Date();
    Date death = new Date();
    GoodLifeSpan goodLifeSpan = new GoodLifeSpan(birth, death);

    // save the birth and death dates as strings
    String birthResult1 = goodLifeSpan.getBirthDate().toString();
    String deathResult1 = goodLifeSpan.getDeathDate().toString();
    // ensure they are the same as the original birth and death dates
    assertEquals(birthResult1, birth.toString());
    assertEquals(deathResult1, death.toString());

    // get the dates from the GoodLifeSpan object and change the retrieved date.
    Date tempBirthDate = goodLifeSpan.getBirthDate();
    tempBirthDate.setTime(tempBirthDate.getTime() - DAY_IN_MILLISECONDS); // born one day earlier
    Date tempDeathDate = goodLifeSpan.getDeathDate();
    tempDeathDate.setTime(tempDeathDate.getTime() + DAY_IN_MILLISECONDS); // died one day later

    // show the temp dates do not match the original dates
    assertNotEquals(birthResult1, tempBirthDate.toString());
    assertNotEquals(deathResult1, tempDeathDate.toString());

    // show the GoodLifeSpan dates match the original dates
    assertEquals(birthResult1, goodLifeSpan.getBirthDate().toString());
    assertEquals(deathResult1, goodLifeSpan.getDeathDate().toString());
  }

}