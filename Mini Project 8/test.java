import java.util.Scanner;
import java.util.ArrayList;

class test {
  public static void characterChecker(ArrayList<Character> expression) {
    ArrayList<Character> newExpression = expression;
    ArrayList update = new ArrayList();
    ArrayList<Integer> indexValues = new ArrayList<Integer>();

    System.out.println(newExpression);

    int conversion = 0;
    int multiplication = 0;
    int addition = 0;

    for (int i = 0; i < newExpression.size(); i++) {
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
        int y = Character.getNumericValue(newExpression.get(x + 1));
        int z = Character.getNumericValue(newExpression.get(x + 2));

        update.set(x, (y*z));

        for (int l = 0; l < 2; l++) {
          update.remove((x + 1));
        }

      } else if (newExpression.get(x).equals('T')) {
        
      }
    }

    System.out.println(update);


    System.out.println(conversion);
    System.out.println(multiplication);
    System.out.println(addition);

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
