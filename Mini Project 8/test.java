import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function below is used to check all of the charcters in the ArrayList.
     // It then changes the values by using another arraylist and for loops.
  public static void characterChecker(ArrayList<Character> expression) {
    // The arraylists below are used to contain the argument and the new ArrayList with the changed values.
    ArrayList<Character> newExpression = expression;

    ArrayList update = new ArrayList();
    ArrayList<Integer> indexValues = new ArrayList<Integer>();

    System.out.println(newExpression);

    int conversion = 0;
    int multiplication = 0;
    int addition = 0;

    // The for loop below is used as a linear search algorithm.
       // If an element is found that matches the characters A, B, or C, then the values for those letters will replace them in the "update" arraylist.
    for (int i = 0; i < newExpression.size(); i++) {
      // During the for loop, all of the elements are added to the ArrayList.
         // It's important to add them so that we can have all of the elements of the original list in their original data type.
      update.add(newExpression.get(i));

      if (newExpression.get(i).equals('A')) {
        conversion += 10;

        update.set(i, 10);
      } else if (newExpression.get(i).equals('B')) {
        conversion += 11;

        update.set(i, 11);
      } else if (newExpression.get(i).equals('C')) {
        conversion += 12;

        update.set(i, 12);
      }
    }

    for (int x = 0; x < newExpression.size(); x++) {
      if (newExpression.get(x).equals('*')) {
        if (!(newExpression.get(x + 1).equals('T')) && !(newExpression.get(x + 2).equals('T'))) {
          int y = Character.getNumericValue(newExpression.get(x + 1));
          int z = Character.getNumericValue(newExpression.get(x + 2));

          update.set(x, (y*z));

          for (int l = 0; l < 2; l++) {
            update.remove((x + 1));
          }
        } else {
            // The else statement here is used when you're multiplying two numbers with a "T".
               // E.g. *T12 or *1T2

            // The if statement below is used to see if the T is in the first index value after the "*".
               // I.e. *T..
            if (newExpression.get((x + 1)).equals('T')) {
              // The two int variables below are used to change the value of the value of the variables in the second and third index to integers from characters.
                 // This is so that we can use binary functions like "*", "+", and etc without having errors.
              int test = Character.getNumericValue(newExpression.get(x + 2));
              int test1 = Character.getNumericValue(newExpression.get(x + 3));

              // The variable below is used to store the "T" value of the index.
              int newValue = (test * 3) + 3;

              update.set((x+1), newValue);
              update.set((x+2), test1);
              update.remove(x+3);

              //System.out.println(update);

              update.set((x+1), (newValue * test1));
              update.remove(x+2);

              //System.out.println(update);
          } else if (newExpression.get((x + 2)).equals('T')) {
            int test = Character.getNumericValue(newExpression.get(x + 1));
            int test1 = Character.getNumericValue(newExpression.get(x + 3));

            int newValue = (test * 3) + 3;

            update.set((x+1), newValue);
            update.set((x+2), test1);
            update.remove(x+3);

            System.out.println(update);

            update.set((x+1), (newValue * test1));
            update.remove(x+2);
          }
        }

      } else if (newExpression.get(x).equals('T')) {

        //update.set(x, (update.get(x + 1)));
      }
    }

    System.out.println(update);
  }

  public static ArrayList mathFunction(){
    Scanner input = new Scanner(System.in);
    ArrayList<Character> digits = new ArrayList();

    System.out.println("Please input the expression ");
    String expression = input.nextLine();

    for (int i = 0; i < expression.length(); i++) {
      digits.add(expression.charAt(i));
    }

    return digits;
  }

  public static void main(String[] args) {
    ArrayList<Character> array = mathFunction();
    characterChecker(array);
  }
}
