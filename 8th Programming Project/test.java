import java.util.Scanner;
import java.util.ArrayList;

class test {
  public static void characterChecker(String inputFunction) {
    String finalFunction = inputFunction;
    ArrayList<Object> finalFunctionArray = new ArrayList<Object>();

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
          int n = Character.getNumericValue(finalFunction.charAt(m+ 2));

          finalFunctionArray.set((m + 1), ((n *3) + 3));
          finalFunctionArray.remove(m+2);
          break;
        } else if (finalFunction.charAt(m + 2) == 'T') {
          
        }
      }
    }

    System.out.println(finalFunction);
    System.out.println(finalFunctionArray);
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
