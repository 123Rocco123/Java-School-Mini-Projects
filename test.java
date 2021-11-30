import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class test {
  // This function will record the target value that the user wants to achieve in the game.
  public static int targetScore() {
    // A scanner object is used for the input.
    Scanner input = new Scanner(System.in);

    // Below are the print statement, and the input statement.
    System.out.print("Target score? ");
    int target = input.nextInt();

    // We return the target score so that it can be saved in the game function below.
    return target;
  }

  // The cardFunc function is used to create the initial ArrayList that is used to store the deckOfCards.
  public static ArrayList<Integer> cardFunc() {
    // Below we use an ArrayList since its mutable, and we can add values later on.
    ArrayList<Integer> deckOfCards = new ArrayList<Integer>();

    // The variable below is used for the while loop condition.
    int i = 0;

    // The while loop will repeat itself 4 times, and each time will iterate the for loop inside of it.
    while(i < 4) {
      // The for loop is used to add the values 1 to 10 to the deckOfCards ArrayList.
      for (int x = 0; x < 10; x++) {
        deckOfCards.add((x + 1));
      }

      // The i++ below is used to increase the value of the variable "i" by 1 so as to not create an inifite loop.
      i++;
    }

    // We return the deckOfCards ArrayList which is then stored inside of the ArrayList in the game function.
    return deckOfCards;
  }

  // The game function is used to keep the main algorithm that we use to actually make the game possible.
  public static void game() {
    // The ArrayList is an integer one, and contains the call of the cardFunc function.
       // Since we returned the ArrayList in the cardFunc function, it will be stored inside of the cards ArrayList.
    ArrayList<Integer> cards = cardFunc();

    // The integer varaibles below are used to store the player's score, the round that they're playing in, and the target score that they want to achieve.
    int score = 0;
    int round = 1;
    int target = targetScore() - 1;

    // The Random object below is used to generate a random number.
    Random randomCard = new Random();
    // The integer card variable below is used to store a random card that we get out of the cards ArrayList.
       // It uses the random object, randomCard, defined above, and uses the size of the list to get a card.
    int card = cards.get(randomCard.nextInt((cards.size())));

    // condition used to break the loop.
    boolean higherOrLower = true;

    // Scanner object for the input method.
    Scanner input = new Scanner(System.in);

    // While loop used to repeat the game questions.
    while (higherOrLower == true) {
      // The for loop is used to remove the card that the player drew.
         // It iterates through the arraylist, and remove the first instance of that card.
      for (int i = 0; i < cards.size(); i++) {
        if (card == cards.get(i)) {
          cards.remove(i);
          break;
        }
      }

      // The variable below is used to store the value of the new card.
      int newCard = cards.get(randomCard.nextInt((cards.size())));;

      System.out.println("I drew a " + card);

      System.out.println("Round " + round + ": Higher or lower? (h/l) ");
      String choice = input.nextLine();

      // If the player has chosen that the next card will be lower, then the if statement below is executed.
      if (choice.equals("l")) {
        // If the user is correct, their score will increase by one, and their round by one.
        if (newCard < card) {
          score += 1;
          round += 1;

          // If the score meets the target, then the player will have won.
          if (score == target) {
            System.out.println("You win!");

            // This is used to break the loop.
            higherOrLower = false;
          }
          // If the user is incorrect, then the else statement telling them that will execute.
        } else {
          System.out.println("Nice try, you scored " + score);
          higherOrLower = false;
        }
        // Same if statement as above, with the difference being that instead of "l", "h" is used.
      } else if (choice.equals("h")) {
        if (newCard > card) {
          score += 1;
          round += 1;

          if (score == target) {
            System.out.println("You win!");

            higherOrLower = false;
          }
        } else {
          System.out.println("Nice try, you scored " + score);
          higherOrLower = false;
        }
        // If what the users wrote is not "h" or "l", then they'll get an error message.
      } else {
        System.out.println("Invalid input");
      }

      // Below is used to store the new card in the card variable to see if the next new card is greater or lesser than the current newcard.
      card = newCard;
    }
  }

  public static void main(String[] args) {
    game();
  }
}
