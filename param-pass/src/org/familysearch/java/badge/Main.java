package org.familysearch.java.badge;

import java.util.Date;

public class Main {

  private static final String NAME_DUKE_STRING = "Duke";
  private static final String NAME_ROVER_STRING = "Rover";
  private static final String NAME_FIFI_STRING = "Fifi";
  private static final int ONE_DAY = 1000*60*60*24;

  public static void main(String[] args) {
    Date birthDate = new Date();
    Dog myDog = new Dog(NAME_DUKE_STRING, birthDate, 7);
    Dog tempDog = myDog;
    Dog cloneDog = myDog.clone();

    System.out.println("========================================================================");
    System.out.println("myDog: " + myDog.dump());
    System.out.println("tempDog: " + tempDog.dump());
    System.out.println("cloneDog: " + cloneDog.dump());

    System.out.println("My dog's name is: " + myDog.getName());

    dogTrick(myDog, cloneDog , 21, NAME_FIFI_STRING);
    System.out.println("My dog's name changed to Fifi: " +  myDog.getName().equals(NAME_FIFI_STRING));
    System.out.println("I have the same dog (tempDog): " + tempDog.equals(myDog));
    System.out.println("I have the same dog (cloneDog): " + cloneDog.equals(myDog));

    System.out.println("========================================================================");
    System.out.println("myDog: " + myDog.dump());
    System.out.println("tempDog: " + tempDog.dump());
    System.out.println("cloneDog: " + cloneDog.dump());

    Dog yourDog = new Dog(NAME_ROVER_STRING, new Date(birthDate.getTime() + ONE_DAY), 14);

    System.out.println("===Show Dogs=====================================================================");
    System.out.println("My Dog: " + myDog.dump());
    System.out.println("Temp Dog: " + tempDog.dump());
    System.out.println("Clone Dog: " + cloneDog.dump());
    System.out.println("Your Dog: " + yourDog.dump());

    myDog.dogSwapContents(tempDog);

    System.out.println("===Swap myDog & tempDog==========================================================");
    System.out.println("My Dog: " + myDog.dump());
    System.out.println("Temp Dog: " + tempDog.dump());
    System.out.println("Clone Dog: " + cloneDog.dump());
    System.out.println("Your Dog: " + yourDog.dump());

    myDog.dogSwapContents(yourDog);

    System.out.println("===Swap myDog & yourDog==========================================================");
    System.out.println("My Dog: " + myDog.dump());
    System.out.println("Temp Dog: " + tempDog.dump());
    System.out.println("Clone Dog: " + cloneDog.dump());
    System.out.println("Your Dog: " + yourDog.dump());

    tempDog.dogSwapContents(cloneDog);

    System.out.println("===Swap tempDog & cloneDog=======================================================");
    System.out.println("My Dog: " + myDog.dump());
    System.out.println("Temp Dog: " + tempDog.dump());
    System.out.println("Clone Dog: " + cloneDog.dump());
    System.out.println("Your Dog: " + yourDog.dump());
  }

  public static void dogTrick(Dog dog, final Dog cloneDog, int weightValue, final String newDogName) {
    System.out.println("Is the dog's name Duke? " + dog.getName().equals(NAME_DUKE_STRING));
    System.out.println("Is the clone dog's name Duke? " + cloneDog.getName().equals(NAME_DUKE_STRING));

//    newDogName = "Astro";

    dog.setName(newDogName);
    System.out.println("Dog's name changed to " + newDogName + ": " + dog.getName().equals(newDogName));

//    cloneDog = new Dog("CloneDog", dog.getBirthDate(), dog.getWeight());
    cloneDog.resetValues(newDogName, cloneDog.getBirthDate(), weightValue);
    System.out.println("Clone Dog's name changed to " + newDogName + ": " + cloneDog.getName().equals(newDogName));
    System.out.println("CloneDog=" + cloneDog.dump());

  }

}
