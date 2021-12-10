import java.util.Scanner;
import java.util.ArrayList;

class variables {
  ArrayList originalExpression = new ArrayList();
  ArrayList<String> finalExpression = new ArrayList<String>();
}


class test {
  public static void expresssionChecker(variables classObject) {
    variables classObject1 = classObject;

    for (int i = 0; i < classObject1.originalExpression.size(); i++) {
      if (classObject1.originalExpression.get(i).equals('A')) {
        classObject1.originalExpression.set(i, 10);
      } else if (classObject1.originalExpression.get(i).equals('B')) {
        classObject1.originalExpression.set(i, 11);
      } else if (classObject1.originalExpression.get(i).equals('C')) {
        classObject1.originalExpression.set(i, 12);
      }
    }

    System.out.println(classObject1.originalExpression);
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
