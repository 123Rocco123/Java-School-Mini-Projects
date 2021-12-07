import java.util.Scanner;
import java.util.ArrayList;

class UniversalRelayTeam {
  String country;

  int disability1;
  int disability2;
  int disability3;
  int disability4;
}

class test {
  public static void accessor(String teamName, int disability1, int disability2, int disability3, int disability4, ArrayList<Integer> values) {
    UniversalRelayTeam team = new UniversalRelayTeam();
    ArrayList<String> validOrNot = new ArrayList<String>();

    team.country = teamName;
    team.disability1 = disability1;
    team.disability2 = disability2;
    team.disability3 = disability3;
    team.disability4 = disability4;

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

    if (validOrNot.size() == 0) {
      System.out.println("The " + team.country + " team is: Leg 1, T" + disability1 + "; Leg 2, T" + disability2 + "; Leg 3, T"+ disability3 + "; Leg 4, T" + disability4);
    } else {
      System.out.println("The " + team.country + " team is: Leg 1, T" + disability1 + "; Leg 2, T" + disability2 + "; Leg 3, T"+ disability3 + "; Leg 4, T" + disability4);

      for (int x = 0; x < validOrNot.size(); x++) {
        System.out.println("Leg " + validOrNot.get(x) + " is not legal.");
      }
    }
  }

  public static void teamAssembler() {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> disabilities = new ArrayList<Integer>();

    String[] questions = {"What country is the team representing? ",
                          "What is the disability class for leg "};

    System.out.print(questions[0]);
    String teamName = input.nextLine();

    for (int i = 1; i < 5; i++) {
      System.out.print(questions[1] + i + "? T ");
      disabilities.add(input.nextInt());

      input.nextLine();
    }

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
