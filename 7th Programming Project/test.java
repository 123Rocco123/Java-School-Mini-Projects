import java.util.Scanner;
import java.util.ArrayList;

// The constructor class below contains the variables used when constructing a team.
class UniversalRelayTeam {
  String country;

  int disability1;
  int disability2;
  int disability3;
  int disability4;
}

// The class below contains the main algorithm used for the program.
class test {
  /* The function below is used to access the "UniversalRelayTeam" class above.
     It's also used to see if the disabilities that the user inputted are valid or not.
     The arguments are used to pass in the disabilities that the user wrote for the team, the team name, and the disabilities in an Array format to more easily check if they're valid or not. */
  public static void accessor(String teamName, int disability1, int disability2, int disability3, int disability4, ArrayList<Integer> values) {
    // Two objects are created below, the class object, and an ArrayList object.
       // "validOrNot" is used to store which of the disability types are invalid for the different Legs, while "UniversalRelayTeam" is used to create an object of the class.
    UniversalRelayTeam team = new UniversalRelayTeam();
    ArrayList<String> validOrNot = new ArrayList<String>();

    // The assignments below are used to add the disablities to the class object's instance variables.
    team.country = teamName;
    team.disability1 = disability1;
    team.disability2 = disability2;
    team.disability3 = disability3;
    team.disability4 = disability4;

    // The for loop below with the if-else if block inside of it is used to check the indexes of the "values" ArrayList to see if the values at those indexes are valid or not.
       // If the values are not valid, then the number of the leg and what the user wrote are added to the "validOrNot" ArrayList.
    for (int i = 0; i < values.size(); i++) {
      if (i == 0 && values.get(i) != 11 && values.get(i) != 13) {
        validOrNot.add("1 (T" + disability1 + ")");
      } else if (i == 1 && values.get(i) != 61 && values.get(i) != 62) {
        validOrNot.add("2 (T" + disability2 + ")");
      } else if (i == 2 && values.get(i) != 35 && values.get(i) != 36) {
        validOrNot.add("3 (T" + disability3 + ")");
      } else if (i == 3 && values.get(i) != 51 && values.get(i) != 52) {
        validOrNot.add("4 (T" + disability4 + ")");
      }
    }

    // The if statements below are used to check the size of the "validOrNot" ArrayList.
       // If its longer than 0, then that means that there was something which was not a valid disability, therefore, the else statement will print out the details of the team, and the disability / disabilities which aren't valid.
    if (validOrNot.size() == 0) {
      System.out.println("The " + team.country + " team is: Leg 1, T" + disability1 + "; Leg 2, T" + disability2 + "; Leg 3, T"+ disability3 + "; Leg 4, T" + disability4);
    } else {
      System.out.println("The " + team.country + " team is: Leg 1, T" + disability1 + "; Leg 2, T" + disability2 + "; Leg 3, T"+ disability3 + "; Leg 4, T" + disability4);

      for (int x = 0; x < validOrNot.size(); x++) {
        System.out.println("Leg " + validOrNot.get(x) + " is not legal.");
      }
    }
  }

  // The function below is used to gather the information about the team.
  public static void teamAssembler() {
    // Scanner object used for user input, and the "disablities" ArrayList to store all of the disablities that the user wrote.
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> disabilities = new ArrayList<Integer>();

    // Array used to contain the questions which have to be asked to the user.
       // Can be replaced with a series of System.out.print statements if need be.
    String[] questions = {"What country is the team representing? ",
                          "What is the disability class for leg "};

    // The print statement below asks the country, and the scanner object is used to collect the answer.
    System.out.print(questions[0]);
    String teamName = input.nextLine();

    // The for loop below is used to repeat the same question with the counter used to print out the leg number.
    for (int i = 1; i < 5; i++) {
      System.out.print(questions[1] + i + "? T ");
      // The answer that the user wrote is directly applied to the "disablities" ArrayList.
      disabilities.add(input.nextInt());

      // To avoid any errors by using a "nextInt()" inside of a loop, a "nextLine()" is added at the end to remove any excess from the above input.
      input.nextLine();
    }

    // The variables below are used to store each individual disability so that they can be passed inside of the function call below, and stored inside of the instance variables of the class object in the "accessor" function.
    int disability1 = disabilities.get(0);
    int disability2 = disabilities.get(1);
    int disability3 = disabilities.get(2);
    int disability4 = disabilities.get(3);

    accessor(teamName, disability1, disability2, disability3, disability4, disabilities);
  }

  public static void main(String[] args) {
    teamAssembler();
  }
}
