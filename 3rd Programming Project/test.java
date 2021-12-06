// Grade F: Short Assessed Programming Exercise 3: Making Decisions

import java.util.Scanner;

public class test {
  public static boolean disabled() {
    Scanner input = new Scanner(System.in);

    boolean disability;

    System.out.println("Do you have a disability that allows you to park in a disabled parking spot (yes / no)? ");

    // The following variable is used to hold the user input to the previous question.
    String disabled = input.nextLine();

    // Conditional statements used to contain the information of if the user is disabled or not.
    if (disabled.equals("yes")) {
      disability = true;
      return disability;
    } else {
      disability = false;
      return disability;
    }
  }

  // Function used to track the amount of time that the user is planning of parking their car.
  public static int durationOfStay() {
    Scanner input = new Scanner(System.in);

    // Array containing the hours that a person can park their car for.
    String[] hours = {"1) 1",
                      "2) 2 - 4",
                      "3) 5 - 6",
                      "4) 7 - 8"};

    System.out.println("How long are you going to stay in the parking space (choose from list below)? ");


    for (String i : hours) {
      System.out.println(i);
    }

    int parkingStay = input.nextInt();
    return parkingStay;
  }

  public static boolean localOld() {
    Scanner input = new Scanner(System.in);
    boolean localBadgeBool;

    System.out.println("Do you have a \"I Live Locally Badge\" (yes / no)");

    String localBadge = input.nextLine();

    if (localBadge.equals("yes")) {
      localBadgeBool = true;
      return localBadgeBool;
    } else {
      localBadgeBool = false;
      return localBadgeBool;
    }
  }

public static boolean oldAgePens() {
    Scanner input = new Scanner(System.in);
    boolean oldAgePensioner;

    System.out.println("Are you an OAP (yes / no)?");

    String oAP = input.nextLine();

    if (oAP.equals("yes")) {
      oldAgePensioner = true;
      return oldAgePensioner;
    } else {
      oldAgePensioner = false;
      return oldAgePensioner;
    }
}

public static double baseCostFunction(int hours) {
  double initialCost = 0;

  if (hours == 1) {
    initialCost = 3.00;
  } else if (hours == 2 || hours == 3 || hours == 4) {
    initialCost = 4.00;
  } else if (hours == 5 || hours == 6) {
    initialCost = 4.50;
  } else if (hours == 7 || hours == 8) {
    initialCost = 5.50;
  }

  return initialCost;
}

public static void overallCost(boolean local, boolean oldAgePens, double baseCost) {
  double newCost;

  if (local == true && oldAgePens == true) {
    newCost = baseCost - 3;
    System.out.println("The parking cost is: " + newCost);
  } else if (local == true && oldAgePens == false) {
    newCost = baseCost - 1;
    System.out.println("The parking cost is: " + newCost);
  } else if (local == false && oldAgePens == true) {
    newCost = baseCost - 2;
    System.out.println("The parking cost is: " + newCost);
  } else {
    System.out.println("The parking cost is: " + baseCost);
  }
}

public static void callFunc(){
  int duration = durationOfStay();
  boolean local = localOld();
  boolean oldAge = oldAgePens();
  double baseCost = baseCostFunction(duration);

  overallCost(local, oldAge, baseCost);
}

  public static void main(String[] args ){
    // The variable that will contain the returned value of the "disabled" function.
    boolean freeParking = disabled();

    if (freeParking == true) {
      System.out.println("Free Parking for you.");
    } else {
      callFunc();
    }
  }
}
