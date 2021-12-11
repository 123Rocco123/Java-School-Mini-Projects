import java.util.Scanner;
import java.util.ArrayList;

class variables {
  ArrayList<Character> originalExpression = new ArrayList<Character>();
  ArrayList finalExpression = originalExpression;
}


class test {
  public static void expresssionChecker(variables classObject) {
    variables classObject1 = classObject;

    for (int i = 0; i < classObject1.originalExpression.size(); i++) {
      if (classObject1.originalExpression.get(i).equals('A')) {
        classObject1.finalExpression.set(i, 10);
      } else if (classObject1.originalExpression.get(i).equals('B')) {
        classObject1.finalExpression.set(i, 11);
      } else if (classObject1.originalExpression.get(i).equals('C')) {
        classObject1.finalExpression.set(i, 12);
      } else if (classObject1.originalExpression.get(i).equals('*')) {
        if (!classObject1.originalExpression.get(i + 1).equals('T') && !classObject1.originalExpression.get(i + 2).equals('T')) {
          int x = Character.getNumericValue(classObject1.originalExpression.get(i + 1));
          int y = Character.getNumericValue(classObject1.originalExpression.get(i + 2));

          classObject1.finalExpression.set(i, (x * y));

          classObject1.finalExpression.remove(i + 1);
          classObject1.finalExpression.remove(i + 1);
        } else if (classObject1.originalExpression.get(i + 1).equals('T')) {
          int x = Character.getNumericValue(classObject1.finalExpression.get(i + 2));

          // int y = x + (x + 1) + (x + 2)

          classObject1.finalExpression.set()
        }
      }
    }

    System.out.println(classObject1.finalExpression);
  }

  public static void expression() {
    Scanner input = new Scanner(System.in);
    variables classObject = new variables();

    System.out.print("Please input the expression ");
    String inputValue = input.nextLine();

    for (int i = 0; i < inputValue.length(); i++) {
      classObject.originalExpression.add(inputValue.charAt(i));
    }
    expresssionChecker(classObject);
  }

  public static void main(String[] args) {
    expression();
  }
}
