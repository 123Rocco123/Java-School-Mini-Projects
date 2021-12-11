import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function below is used to check all of the characters in the string which are then converted to the desired function, and then stored into the ArrayList.
  public static void characterChecker(String inputFunction) {
    // The String below is used to store the string that we pass into the function.
       // The string which we pass in as an argument contains the formula which we have to complete.
    String finalFunction = inputFunction;
    // The ArrayList below is used an Object type, and is used to store the final answer.
       // The reason that the ArrayList is an Object type is because of the fact that with an Objcet type we can store different data types all in the same data.
    ArrayList<Object> finalFunctionArray = new ArrayList<Object>();

    // The first for loop is used to quickly convert and basic variables in the equation.
       // I.e. Numbers 1 through 9, A, B, and C, *.
    for (int x = 0; x < inputFunction.length(); x++) {
      finalFunctionArray.add(0);
    }

    for (int i = 0; i < inputFunction.length(); i++) {
      if (Character.getNumericValue(finalFunction.charAt(i)) <= 9 && Character.getNumericValue(finalFunction.charAt(i)) >= 0) {
        finalFunctionArray.set(i, Character.getNumericValue(finalFunction.charAt(i)));
      } else if (finalFunction.charAt(i) == 'A') {
        finalFunctionArray.set(i, 10);

      } else if (finalFunction.charAt(i) == 'B') {
        finalFunctionArray.set(i, 11);

      } else if (finalFunction.charAt(i) == 'C') {
        finalFunctionArray.set(i, 12);

      } else if (finalFunction.charAt(i) == '*') {
        finalFunctionArray.set(i, '*');
      }
    }

    for (int m = 0; m < inputFunction.length(); m++) {
      if (finalFunction.charAt(m) == '*') {
        if (finalFunction.charAt(m + 1) != 'T' && finalFunction.charAt(m + 2) != 'T') {
          int y = Character.getNumericValue(finalFunction.charAt(m+1));
          int z = Character.getNumericValue(finalFunction.charAt(m+2));

          finalFunctionArray.set(m, (y * z));

          finalFunctionArray.remove(m+1);
          finalFunctionArray.remove(m+1);
        } else if (finalFunction.charAt(m + 1) == 'T') {
          int n = Character.getNumericValue(finalFunction.charAt(m + 2));

          finalFunctionArray.set((m + 1), ((n *3) + 3));
          finalFunctionArray.remove(m+2);
          break;
        } else if (finalFunction.charAt(m + 2) == 'T') {
          int b = Character.getNumericValue(finalFunction.charAt(m + 3));

          finalFunctionArray.set((m + 2), ((b *3) + 3));
          finalFunctionArray.remove(m+3);
          break;
        }
      }
    }

    System.out.println(finalFunction);
    System.out.println(finalFunctionArray);

    if (finalFunctionArray.size() > 1) {
      String stringToOverlap = "";

      for (int indexValues = 0; indexValues < finalFunctionArray.size(); indexValues++) {
        stringToOverlap += finalFunctionArray.get(indexValues);
      }

      characterChecker(stringToOverlap);
    }
  }

  // The "input()" function is used to ask the user the expression that they want to work on.
  public static void input() {
    Scanner input = new Scanner(System.in);

    String inputFunction = "";

    System.out.print("Expression: ");
    inputFunction = input.nextLine();

    characterChecker(inputFunction);
  }

  public static void main(String[] args) {
    input();
  }
}
