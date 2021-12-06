import java.util.Scanner;

class test {
  public static void main(String[] args) {
    input();
  }

  public static void input(){
    // The Scanner variable is used to get the user input.
    Scanner input = new Scanner(System.in);

    // The outputs are questions on the dimension of the room so as to do the calculation of the amount of balloons required.
    System.out.println("Enter the length of the room (m): ");
    double length = input.nextDouble();

    System.out.println("Enter the width of the room (m): ");
    double width = input.nextDouble();

    System.out.println("Enter the height of the room (m): ");
    double height = input.nextDouble();

    System.out.println("What are the dimensions of the balloons (m^3)? ");
    double BalloonDimensions = input.nextDouble();

    calc(length, width, height, BalloonDimensions);
  }

  public static void calc(double length, double width, double height, double BalloonDimensions){
    // The variable will store the dimensions of the room in meter squared.
    double DimensionsOfRoom = length * width * height;

    double AmountOfBallons = DimensionsOfRoom / BalloonDimensions;

    /* The variable below is used to round off the amount of balloons that are needed to fill out the room.
          Just like in Math, if the decimal is 0.5 or greater its rounded up, and if not its rounded down. */
    int AmountOfBallons1 = (int) (Math.round(AmountOfBallons));

    System.out.println("The dimensions of the room are: " + DimensionsOfRoom);

    // The final statement telling the user the amount of ballons required to fill the room.
    System.out.println("You're going to need " + AmountOfBallons1 + " balloons to fill out the room.");
  }
}
