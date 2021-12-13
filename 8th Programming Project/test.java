import java.util.Scanner;
import java.util.ArrayList;

class test {
  // The function below is used to check all of the characters in the string which are then converted to the desired function, and then stored into the ArrayList.
  public static void characterChecker(String inputFunction) {
    // The String below is used to store the string that we pass into the function.
       // The string which we pass in as an argument contains the formula which we have to complete.
    String finalFunction = inputFunction;

    System.out.println(finalFunction);
    // The ArrayList below is used an Object type, and is used to store the final answer.
       // The reason that the ArrayList is an Object type is because of the fact that with an Objcet type we can store different data types all in the same data.
    ArrayList<Object> finalFunctionArray = new ArrayList<Object>();

    // The for loop here is used to add 0s to the ArrayList so as to allow for us to change the values later on in the program.
    for (int x = 0; x < inputFunction.length(); x++) {
      finalFunctionArray.add(0);
    }

    // The first for loop is used to quickly convert and basic variables in the equation.
       // I.e. Numbers 1 through 9, A, B, and C, *.
    for (int i = finalFunctionArray.size() - 1; i >= 0; i--) {
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

    for (int m = finalFunctionArray.size() - 1; m >= 0; m--) {
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

    System.out.println(finalFunctionArray);

    for (int TChecker = finalFunctionArray.size() - 1; TChecker >= 0; TChecker--) {
      if (finalFunction.charAt(TChecker) == 'T') {
        System.out.println(TChecker);
        int Tnext = (Integer)finalFunctionArray.get(TChecker + 1);

        Tnext = (Tnext * 3) + 3;

        finalFunctionArray.set(TChecker, Tnext);
        finalFunctionArray.remove(TChecker + 1);
        break;
      }
    }

    System.out.println(finalFunction);
    System.out.println(finalFunctionArray);

    // The if statement below is used for recursion.
       // The if statement checks if the array is larger than 1, if it is, then it means that the equation has yet to finish.
    if (finalFunctionArray.size() > 1) {
      // The string below is used to store the new string which we pass into the characterChecker.
         // It contains the equation which we're supposed to solve in a string format.
      String stringToOverlap = "";

      // Since the progress of solving the equation is stored isnide of the "finalFunctionArray" Array, we have to use a for loop to iterate through the list, and append all of the elements to the string above.
      for (int indexValues = 0; indexValues < finalFunctionArray.size(); indexValues++) {
        stringToOverlap += finalFunctionArray.get(indexValues);
      }

      // Recursion then occurs below when we call the function "characterChecker" from within characterChecker.
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
