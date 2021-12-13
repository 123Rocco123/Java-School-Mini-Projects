import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function below is used to check all of the characters in the string which are then converted to the desired function, and then stored into the ArrayList.
  public static void characterChecker(String inputFunction1, ArrayList<Integer> Operands1, ArrayList<Character> Operators1, boolean recursion) {
    ArrayList<Integer> Operands = new ArrayList<Integer>();
    ArrayList<Character> Operators = new ArrayList<Character>();

    String inputFunction = inputFunction1;

    if (recursion == false) {
      for (int i = 0; i < inputFunction.length(); i++) {
        Operators.add('0');
        Operands.add(0);
      }

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
    } else if (recursion == true) {
      Operands = Operands1;
      Operators = Operators1;
    }

    for (int j = Operands.size() - 1; j >= 0; j--) {
      if (Operators.get(j) == '*') {
        if (Operators.get(j + 1) != 'T' && Operators.get(j + 2) != 'T') {
          Operands.set(j, (Operands.get(j + 1) * Operands.get(j + 2)));

          Operands.remove(j+1);
          Operands.remove(j+1);

          Operators.remove(j+1);
          Operators.remove(j);

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
        Operands.set(j, ((Operands.get(j + 1) * 3) + 3));

        Operands.remove(j+1);

        Operators.set(j, '0');
        Operators.remove(j+1);
      }
    }

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

    System.out.print("Expression: ");
    inputFunction = input.nextLine();

    characterChecker(inputFunction, Number1, Number2, false);
  }

  public static void main(String[] args) {
    input();
  }
}
