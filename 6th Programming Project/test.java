// While Loop Short Assessment
import java.util.Scanner;

class test {
  public static void whileFunc() {
    Scanner input = new Scanner(System.in);

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
        String time = "";

        // To make the string look nice, if the minutes that the train is late by are 1 or 0, then the variable "time" will equal minute, if not, then it will be minutes.
        if (leastLate == 1 || leastLate == 0) {
          time = " minute";
        } else {
          time = " minutes";
        }

        System.out.println("");
        System.out.println("The trains were in total " + totalMins + " minutes late.");
        System.out.println("The most punctual train was to " + startingPosition + ". It was " + leastLate + time + " late.");

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
      if (leastLate == null) {
        leastLate = lateMins;
        startingPosition = startPoint;
      } else if (leastLate != null && leastLate > lateMins) {
        leastLate = lateMins;
        startingPosition = startPoint;
      }

      // This is used to get rid of the "\n" left by the "input.nextInt();".
      input.nextLine();
    }
  }

  public static void main(String[] args) {
    whileFunc();
  }
}
