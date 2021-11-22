import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The class below is used to check if the values that the user inputted for the disabilities are valid or not.
  public static void checker(ArrayList values, String team) {
    // The "trueOrFalse" ArrayList is used to store if the values are valid.
       // The valuesToCheck is instead used to store the argument "values".
    ArrayList valuesToCheck = values;
    ArrayList<Boolean> trueOrFalse = new ArrayList<Boolean>();

    // The for loop and if statements are used to see if the values are valid or not.
       // If they are then "true" is added to the "trueOrFalse" ArrayList, if not, then "false" is.
    for (int i = 0; i < valuesToCheck.size(); i++) {
      if (((Integer)(valuesToCheck.get(i)) == 11 || (Integer)(valuesToCheck.get(i)) == 13) && (i == 0)) {
        trueOrFalse.add(true);
      } else if (((Integer)(valuesToCheck.get(i)) == 61 || (Integer)(valuesToCheck.get(i)) == 62) && (i == 1)) {
        trueOrFalse.add(true);
      } else if (((Integer)(valuesToCheck.get(i)) == 35 || (Integer)(valuesToCheck.get(i)) == 36) && (i == 2)) {
        trueOrFalse.add(true);
      } else if (((Integer)(valuesToCheck.get(i)) == 51 || (Integer)(valuesToCheck.get(i)) == 52) && (i == 3)) {
        trueOrFalse.add(true);
      } else {
        trueOrFalse.add(false);
      }
    }

    // The print statement below outputs the details of the team.
    System.out.println("The " + team + " team is: Leg 1, T" + valuesToCheck.get(0) + "; Leg 2, T" + valuesToCheck.get(1) + "; Leg 3, T" + valuesToCheck.get(2) + "; Leg 4, T" + valuesToCheck.get(3));

    // The for loop and the if statement below are used to ouput any and all invalid disability types.
    for (int i = 0; i < trueOrFalse.size(); i++) {
      if (trueOrFalse.get(i) == false) {
        System.out.println("Leg " + (i + 1) + " (T" + valuesToCheck.get(i) + ") is not legal.");
      }
    }
  }

  // The accessorMethod is used to access the instance variables in the "test1.java" class.
  public static ArrayList accessorMethod(String country, int Leg1, int Leg2, int Leg3, int Leg4) {
    // Below is the object for the class inside of the "test1.java".
    test1 testObject = new test1();

    // The ArrayList below is used to store the values of the disabilities.
    ArrayList values = new ArrayList();

    testObject.country = country;

    // Below the values of the disabilities are stored inside of the test1 class instance variables.
    testObject.Leg1 = Leg1;
    testObject.Leg2 = Leg2;
    testObject.Leg3 = Leg3;
    testObject.Leg4 = Leg4;

    // The values are also added to the ArrayList, which is then used to check if they're valid or not.
    values.add(Leg1);
    values.add(Leg2);
    values.add(Leg3);
    values.add(Leg4);

    return values;
  }

  // The function below is used to ask the user what the team is, and their disability qualifications.
     // It then calls the accessor method above, passing the values that the user has assigned to it.
  public static void teamAssignment() {
    // The string variable is used to store the country's name.
    String country = "";

    // The leg variables below are used to store the disability numbers.
    int Leg1 = 0;
    int Leg2 = 0;
    int Leg3 = 0;
    int Leg4 = 0;

    // The scanner object below is used to gather the user's input.
    Scanner input = new Scanner(System.in);

    System.out.print("What country is the team representing? ");
    country = input.nextLine();

    // The for loop is used to ask the user 4 times the different disabilities for the different legs.
       // The if else block inside of the for loop is then used to gather the number for each of the diffrent legs.
    for (int i = 1; i <= 4; i++) {
      System.out.print("What is the disability class for leg " + i + "? T ");

      if (i == 1) {
        Leg1 = input.nextInt();
        input.nextLine();
      } else if (i == 2) {
        Leg2 = input.nextInt();
        input.nextLine();
      } else if (i == 3) {
        Leg3 = input.nextInt();
        input.nextLine();
      } else if (i == 4) {
        Leg4 = input.nextInt();
        input.nextLine();
      }
    }

    // Below the ArrayList "access" is used to store the result of the accessorMethod.
    ArrayList access = accessorMethod(country, Leg1, Leg2, Leg3, Leg4);
    // The function call below is used to see if all of the disabilities that the user inputted are in fact valid.
       // The ArrayList above and the country name are passed into the call as arguments.
    checker(access, country);
  }

  public static void main(String[] args) {
    teamAssignment();
  }
}
