import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class Attraction{
  String name;
  int openingTime;
  boolean BankHolidays;
}

class test {
  public static String AttractionsFunc(String Name) {
    // The following are object creations of the class "Attraction" above.
       // What the code is doing is creating different objects of the attraction class, saving them to variables, and then assigning values to the instance variables inside of the class.
          // These values are then used later on in the code to check information about the attractions.
    Attraction Attractions = new Attraction();
    Attractions.name = "The Eden Project";
    Attractions.openingTime = 9;
    Attractions.BankHolidays = true;

    Attraction Attractions1 = new Attraction();
    Attractions1.name = "Tate Modern";
    Attractions1.openingTime = 10;
    Attractions1.BankHolidays = false;

    Attraction Attractions2 = new Attraction();
    Attractions2.name = "London Zoo";
    Attractions2.openingTime = 10;
    Attractions2.BankHolidays = true;

    // The for loop is used to cycle through the indexes of the attractions.
      // If the attraction will match the name that the user wrote, then the time and if its open during bank holidays is outputted.
      if (Name.equals(Attractions.name)) {
        if (Attractions.BankHolidays == true) {
          return(Name + " is open on bank holidays.\n" + "It opens at " + Attractions.openingTime + "am.\n");
        } else {
          return(Name + " is not open on bank holidays.\n" + "It opens at " + Attractions.openingTime + "am.\n");
          }
      } else if (Name.equals(Attractions1.name)) {
        if (Attractions1.BankHolidays == true) {
          return(Name + " is open on bank holidays.\n" + "It opens at " + Attractions1.openingTime + "am.\n");
        } else {
          return(Name + " is not open on bank holidays.\n" + "It opens at " + Attractions1.openingTime + "am.\n");
          }
      } else if (Name.equals(Attractions2.name)) {
        if (Attractions2.BankHolidays == true) {
            return(Name + " is open on bank holidays.\n" + "It opens at " + Attractions2.openingTime + "am.\n");
        } else {
          return(Name + " is not open on bank holidays.\n" + "It opens at " + Attractions2.openingTime + "am.\n");
        }
      } else {
        return("I have no information about that attraction.\n");
      }
  }

  // The Attractions function is used to determine what attraction the user wants to find more information about.
  public static void attractions(int attracAmounts) {

    Scanner input = new Scanner(System.in);

    for (int i = 0; i < attracAmounts; i++) {
      System.out.print("What's the name of attraction " + (i + 1) + "? ");
      String name = input.nextLine();

      System.out.println(AttractionsFunc(name));
    }
  }

  // The function below is used to call the functions above.
  public static void callFunc() {
    Scanner input = new Scanner(System.in);

    System.out.print("How many attractions do you need to know about? ");
    int repetitionTimes = input.nextInt();

    attractions(repetitionTimes);
  }

  public static void main(String[] args) {
    callFunc();
  }
}
