import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function below is used to check all of the characters in the string which are then converted to the desired function, and then stored into the ArrayList.
  public static void characterChecker(String inputFunction1, ArrayList<Integer> Operands1, ArrayList<Character> Operators1, boolean recursion) {
    // The two string arrays are used to contain the operators and operands of the equation.
       // With the operands (numbers) being stored inside of the character ArrayList.
       // The reason that seperate arrayLists are used is because of the fact that if we were to use an object ArrayList, then when we'd have to look for key elements such as "T" and "*", we'd have to always convert the object to a character.
          // And when we'd have to call back the function and operate on the numbers, we'd have to change them from objects to integers. Therefore, it's easier to have 2 seperate Lists which work in tandum with one another.
    ArrayList<Integer> Operands = new ArrayList<Integer>();
    ArrayList<Character> Operators = new ArrayList<Character>();

    // Used to store the string passed into the function.
    String inputFunction = inputFunction1;

    // The reason that the if condition is used to enclose the for loops below is because of the way that they're made.
       // When first initializing the function, we have to add placeholder values to the Arrays above, as well as doing the initial conversions.
       // Therefore, to avoid overwritting the progress that we've made, we have to seperate the function into two groups.
    if (recursion == false) {
      // The for loop just adds 0s to both arrays each representing a character of the equation.
      for (int i = 0; i < inputFunction.length(); i++) {
        Operators.add('0');
        Operands.add(0);
      }

      // The for loop is used as a converter, which checks every element in the string, and depending on what they are they're either added to the integer or character ArrayList.
         // Any number (or letter which can be converted to a number) is added to the integer arraylist, and any operators such as "T" and "*" are added to the character ArrayList.
         // 0s are then used for any values that don't fit.
            // Where 0 for the integer ArrayList represents the operators, and in the character list it represents the numbers.
      for (int y = 0; y < inputFunction.length(); y++) {
        if (inputFunction.charAt(y) == 'A') {
          Operands.set(y, 10);
          Operators.set(y, 'A');

        } else if (inputFunction.charAt(y) == 'B') {
          Operands.set(y, 11);
          Operators.set(y, 'B');

        } else if (inputFunction.charAt(y) == 'C') {
          Operands.set(y, 12);
          Operators.set(y, 'C');

        } else if (Character.getNumericValue(inputFunction.charAt(y)) <= 9 && Character.getNumericValue(inputFunction.charAt(y)) >= 0) {
          Operands.set(y, Character.getNumericValue(inputFunction.charAt(y)));

        } else if (inputFunction.charAt(y) == 'T' || inputFunction.charAt(y) == '*') {
          Operators.set(y, inputFunction.charAt(y));
        }
      }

      // It's important to note if recursion is "true", then we pass in the ArrayLists from the previous step into the ones function's ones.
    } else if (recursion == true) {
      Operands = Operands1;
      Operators = Operators1;
    }

    // The for loop is used to continue the work on the equation.
       // The differences here from the for loop inside of the if condition are that instead of basing ourselves on the string to assign the values, we've already have the ArrayLists with assigned values.
          // Therefore, we simple have to iterate through them, and check if there are any areas where we have to make changes.
    for (int j = Operands.size() - 1; j >= 0; j--) {
      if (Operators.get(j) == '*') {
        if (Operators.get(j + 1) != 'T' && Operators.get(j + 2) != 'T') {
          Operands.set(j, (Operands.get(j + 1) * Operands.get(j + 2)));

          Operands.remove(j+1);
          Operands.remove(j+1);

          Operators.remove(j+1);
          Operators.remove(j);

          // The break statement is important so that we avoid having the for loop iterate throughout the entire ArrayList causing an error.
          break;
        } else if (Operators.get(j + 1) == 'T') {
          Operands.set((j + 1), ((Operands.get(j + 2) * 3) + 3));

          Operands.remove(j+2);

          Operators.remove(j+2);
          Operators.set((j+1), '0');

          break;
        } else if (Operators.get(j + 2) == 'T') {
          Operands.set((j + 2), ((Operands.get(j + 3) * 3) + 3));

          Operands.remove(j+3);

          Operators.remove(j+3);
          Operators.set((j+2), '0');

          break;
        }
      } else if (Operators.get(j) == 'T') {
        // Since we already have the "*" if statement above, which includes what to do if one of the operands is a "T", we just have to have a condition here where we just find the T value of the value to the right of T.
        Operands.set(j, ((Operands.get(j + 1) * 3) + 3));

        Operands.remove(j+1);

        Operators.set(j, '0');
        Operators.remove(j+1);
      }
    }

    // The if condition below is used to check if the size of the operands ArrayList is greater than 1.
       // If its greater than one, then that means that the equation still has to be completed since we don't have a singular answer yet.
    if (Operands.size() > 1) {
      characterChecker(inputFunction, Operands, Operators, true);
    } else {
      System.out.println("The answer is: " + Operands.get(0));
    }
}

  // The "input()" function is used to ask the user the expression that they want to work on.
  public static void input() {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> Number1 = new ArrayList<Integer>();
    ArrayList<Character> Number2 = new ArrayList<Character>();

    String inputFunction = "";

    System.out.print("Please input the expression: ");
    inputFunction = input.nextLine();

    characterChecker(inputFunction, Number1, Number2, false);
  }

  public static void main(String[] args) {
    input();
  }
}
