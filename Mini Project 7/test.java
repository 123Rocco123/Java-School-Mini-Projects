import java.util.Scanner;
import java.util.ArrayList;

class test {
  public static void checker(ArrayList values, String team) {
    ArrayList valuesToCheck = values;
    ArrayList<Boolean> trueOrFalse = new ArrayList<Boolean>();

    for (int i = 0; i < valuesToCheck.size(); i++) {
      valuesToCheck.get(i);

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

    System.out.println("The " + team + " team is: Leg 1, T" + valuesToCheck.get(0) + "; Leg 2, T" + valuesToCheck.get(1) + "; Leg 3, T" + valuesToCheck.get(2) + "; Leg 4, T" + valuesToCheck.get(3));
    for (int i = 0; i < trueOrFalse.size(); i++) {
      if (trueOrFalse.get(i) == false) {
        System.out.println("Leg " + (i + 1) + " (T" + valuesToCheck.get(i) + ") is not legal.");
      }
    }
  }

  public static ArrayList accessorMethod(String country, int Leg1, int Leg2, int Leg3, int Leg4) {
    test1 testObject = new test1();

    ArrayList values = new ArrayList();

    testObject.country = country;

    testObject.Leg1 = Leg1;
    testObject.Leg2 = Leg2;
    testObject.Leg3 = Leg3;
    testObject.Leg4 = Leg4;

    values.add(Leg1);
    values.add(Leg2);
    values.add(Leg3);
    values.add(Leg4);

    return values;
  }

  public static void teamAssignment() {
    String country = "";

    int Leg1 = 0;
    int Leg2 = 0;
    int Leg3 = 0;
    int Leg4 = 0;

    Scanner input = new Scanner(System.in);

    System.out.print("What country is the team representing? ");
    country = input.nextLine();

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

    ArrayList access = accessorMethod(country, Leg1, Leg2, Leg3, Leg4);
    checker(access, country);
  }

  public static void main(String[] args) {
    teamAssignment();
  }
}
