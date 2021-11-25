import java.util.Scanner;
import java.util.ArrayList;

class test {
  public static void characterChecker(ArrayList<Character> expression) {
    int conversion = 0;
    int multiplication = 0;
    int addition = 0;

    for (int i = 0; i < expression.size(); i++) {
      if(expression.get(i).equals('A')) {
        conversion += 10;
      } else if (expression.get(i).equals('B')) {
        conversion += 11;
      } else if (expression.get(i).equals('C')) {
        conversion += 12;
      }
    }

    for (int i = 0; i < expression.size(); i++) {
      if (expression.get(i).equals('*')) {
        multiplication += (expression.get(i + 1) * expression.get(i + 2));
      } else if (expression.get(i).equals('T')) {
        for (int x = 0; x < 3; x++) {
          int Tvariable = Integer.parseInt(String.valueOf(expression.get(i + 1)));
          addition += (Tvariable + x);
        }
      }
    }

    System.out.println(conversion);
    System.out.println(multiplication);
    System.out.println(addition);

  }

  public static ArrayList<Character> mathFunction(){
    Scanner input = new Scanner(System.in);
    ArrayList<Character> digits = new ArrayList<Character>();

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
