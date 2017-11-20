package org.familysearch.java.badge;

import java.util.Date;

public class Main {

  public static final long DAY_IN_MILLISECONDS = 1000*60*60*24;

  public static void main(String[] args) {
    Date today = new Date();
    Date tomorrow = new Date(today.getTime() + DAY_IN_MILLISECONDS);
    System.out.println("Today   : " + today.toString());
    System.out.println("Tomorrow: " + tomorrow.toString());
    System.out.println();

    // show a GoodLifeSpan cannot be altered by re-setting the time on the birth and death dates.
    GoodLifeSpan mayFlyLife = new GoodLifeSpan(today, tomorrow);
    Date mayFlyBirthDate = mayFlyLife.getBirthDate();
    Date mayFlyDeathDate = mayFlyLife.getDeathDate();
    mayFlyBirthDate.setTime(mayFlyBirthDate.getTime() - DAY_IN_MILLISECONDS); // born one day earlier
    mayFlyDeathDate.setTime(mayFlyDeathDate.getTime() + DAY_IN_MILLISECONDS); // died one day later
    System.out.println("May Fly Birth: " + mayFlyLife.getBirthDate().toString());
    System.out.println("May Fly Death: " + mayFlyLife.getDeathDate().toString());
    System.out.println("May Fly Life Span: " + mayFlyLife.getLifeSpanInMilliseconds());
    System.out.println();

    // show a BadLifeSpan can be altered by re-setting the time on the birth and death dates.
    BadLifeSpan mayFlyLife2 = new BadLifeSpan(today, tomorrow);
    Date mayFly2BirthDate = mayFlyLife2.getBirthDate();
    Date mayFly2DeathDate = mayFlyLife2.getDeathDate();
    mayFly2BirthDate.setTime(mayFly2BirthDate.getTime() - DAY_IN_MILLISECONDS); // born one day earlier
    mayFly2DeathDate.setTime(mayFly2DeathDate.getTime() + DAY_IN_MILLISECONDS); // died one day later
    System.out.println("May Fly 2 Birth: " + mayFlyLife2.getBirthDate().toString());
    System.out.println("May Fly 2 Death: " + mayFlyLife2.getDeathDate().toString());
    System.out.println("May Fly 2 Life Span: " + mayFlyLife2.getLifeSpanInMilliseconds());
  }

}
