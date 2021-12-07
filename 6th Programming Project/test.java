// While Loop Short Assessment
import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function is used to output the most on time train, and the total minutes that the trains were late by.
     // The arguments which are passed into the function are: The least late train, the total minutes that the trains were collectively late by, the least lates train starting position.
  public static void codeExecuted(int leastLate, int totalMins, String startingPosition, ArrayList<String> leastLateTrains) {
    String time = "";

    // To make the string look nice, if the minutes that the train is late by are 1 or 0, then the variable "time" will equal minute, if not, then it will be minutes.
    if (leastLate == 1 || leastLate == 0) {
      time = " minute";
    } else {
      time = " minutes";
    }

    // The if-else statement is used to print out different messages when more than one train was the least late.
       // Meaning when more than one train was on schedule, the if statement is executed, if only one train is the most on schedule, then the else statement is used.
    if (leastLateTrains.size() > 0) {
      System.out.println("\nThe trains were in total " + totalMins + " minutes late.");
      System.out.println("The most punctual trains were to " + startingPosition + ". They were " + leastLate + time + " late.");
    } else {
      System.out.println("\nThe trains were in total " + totalMins + " minutes late.");
      System.out.println("The most punctual train was to " + startingPosition + ". It was " + leastLate + time + " late.");
    }
  }

  // The function below contains the while loop which asks the user information about the trains.
  public static void whileFunc() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> leastLateTrains = new ArrayList<String>();

    // The code variable is used as the condition for the while loop.
    boolean code = false;

    /* The variables below are used to store the values of the least late train.
       It's important to note that "null" is used so as to initialize the variables.
       Furthermore, "Integer" is used instead of int with null. */
    Integer leastLate = null;
    int totalMins = 0;
    String startingPosition = null;

    while (code == false) {
      System.out.print("What is the destination of the train that just departed? ");
      String startPoint = input.nextLine();

      // The if condition is used to see if the user input is equal to the string "XXXX". If it is, then the loop will be broken, and the least late train will be outputted.
      if (startPoint.equals("XXXX") && leastLate != null) {
        codeExecuted(leastLate, totalMins, startingPosition, leastLateTrains);

        // Changing the value of "code" to true will break the loop.
        code = true;

        // The "break" keyword is used to exit the rest of the loop at this exact point once the "XXXX" condition has been met.
        break;
      } // If the user inputs the code, and they didn't input any trains, then the following error will occur.
        else if (startPoint.equals("XXXX") && leastLate == null) {
        System.out.println("Error, you haven't inputted any trains.\n");

        // The "continue" keyword is used to skip the rest of the loop once the "XXXX" condition has been met.
           // If we were to use a function call instead, then we'd have a bug where once we use the "XXXX" code, the rest of the code below, would be executed.
        continue;
      }

      // If the code is not written, then the loop will proceed to ask the user how many minutes the train was late by.
         // The answer is then added to the "totalMins" variable.
      System.out.print("How many minutes late was it? ");
      int lateMins = input.nextInt();
      System.out.println("");
      totalMins += lateMins;

      // The following if statements are used to determine what times and places have to be saved.
         // If the value of the variable is equal to null, then anything that can be assigned is assgined.
         // If instead the value isn't equal to null and the current saved value is greater than the new one, then the new one will replace the old.
         // The last if-else statement is used when two trains have the same time.
      if (leastLate == null) {
        leastLate = lateMins;
        startingPosition = startPoint;
      } else if (leastLate != null && leastLate > lateMins) {
        leastLate = lateMins;
        startingPosition = startPoint;
      } else if (leastLate != null & leastLate == lateMins) {
        leastLateTrains.add(startPoint);

        startingPosition += " and " + startPoint;
      }

      // This is used to get rid of the "\n" left by the "input.nextInt();".
      input.nextLine();
    }
  }

  public static void main(String[] args) {
    whileFunc();
  }
}
