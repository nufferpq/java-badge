package org.familysearch.java.badge;

import java.util.Date;

public class Dog {
  String name;
  Date birthDate;
  int weight;

  public Dog(String nameValue, Date date, int weightInPounds) {
    name = nameValue;
    birthDate = date;
    weight = weightInPounds;
  }

  public void resetValues(String nameValue, Date dateValue, int weightValue) {
    setName(nameValue);
    setBirthDate(dateValue);
    setWeight(weightValue);
  }

  public String getName() {
    return name;
  }

  public void setName(String nameValue) {
    this.name = nameValue;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDateValue) {
    this.birthDate = birthDateValue;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weightvalue) {
    this.weight = weightvalue;
  }

  public Dog clone() {
    return new Dog(name, birthDate, weight);
  }

  public void dogSwapContents(Dog otherDog) {
    Dog tempDog = new Dog(this.getName(), this.getBirthDate(), this.getWeight());
    name = otherDog.getName();
    birthDate = otherDog.getBirthDate();
    weight = otherDog.getWeight();
    otherDog.resetValues(tempDog.getName(), tempDog.getBirthDate(), tempDog.getWeight());
  }

  public String dump() {
    return "Name: " + name + "; Birth: " + birthDate.toString() + "; Weight: " + weight + "; Address: " + this;
  }
}
