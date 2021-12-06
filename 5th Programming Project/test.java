// Short Programming Assessment Array
import java.util.Scanner;
import java.util.ArrayList;


class test {
  public static String averageMedals(double totalMedals, ArrayList<Integer> NumberOfMedals) {
    double totalMedals1 = totalMedals;
    ArrayList<Integer> NumberOfMedals1 = NumberOfMedals;
    int sizeOfList = NumberOfMedals1.size();

    for (int x = 0; x < sizeOfList; x++) {
      totalMedals1 += NumberOfMedals1.get(x);
    }

    final double totalMedals2 = totalMedals1;

    return ("Between them they won an average of " + Math.round(totalMedals2 / 5) + " medals each." );
  }

  public static void Olympians() {
    Scanner input = new Scanner(System.in);


    ArrayList<String> OlympiansName = new ArrayList<String>();
    ArrayList<String> Sports = new ArrayList<String>();
    ArrayList<Integer> NumberOfMedals = new ArrayList<Integer>();

    String[] Questions = {"Name Olympians / Paralympian ",
                          "How many medals did he / she win? ",
                          "What sport did he / she compete in? "};

    // Variable containing the length of the array.
    int LengthOfList = OlympiansName.size();

    for (int x = 0; x < 5; x++) {
      for (int i = 0; i < 3; i++) {
          if (i == 0) {
            System.out.print(Questions[i] + (x + 1) + "? ");

            String word = input.nextLine();
            OlympiansName.add(word);
          } else if (i == 1) {
            System.out.print(Questions[i]);

            int word = input.nextInt();
            NumberOfMedals.add(word);

            // This input method is used to consume the remaining "\n" after the "nextInt()" was used.
            input.nextLine();
          } else if (i == 2) {
            System.out.print(Questions[i]);

            String word = input.nextLine();
            Sports.add(word);

            System.out.println("");
          }
        }
    }

    double totalMedals = 0.0;

    System.out.println(averageMedals(totalMedals, NumberOfMedals));

    for (int i = 0; i < 5; i++) {
      System.out.println(Sports.get(i) + ", " + OlympiansName.get(i) + ", " + NumberOfMedals.get(i) + ", ");
    }
  }

public static void main(String[] args) {
    Olympians();
  }
}
