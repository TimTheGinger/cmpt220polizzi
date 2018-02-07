import java.util.Scanner;

public class Problem6_5 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter three (3) numbers: ");
    int num1 = scan.nextInt();
    int num2 = scan.nextInt();
    int num3 = scan.nextInt();

    displaySortedNumbers(num1,num2,num3);
  }

  public static void displaySortedNumbers(double num1, double num2, double num3) {
    double first = 0;
    double second = 0;
    double third = 0;

    if (num1 < num2 && num1 < num3) {
      first = num1;
      if (num2 < num3) {
        second = num2;
        third = num3;
      } else {
        second = num3;
        third = num2;
      }
    } else if (num2 < num1 && num2 < num3) {
      first = num2;
      if (num1 < num3) {
        second = num1;
        third = num3;
      } else {
        second = num3;
        third = num1;
      }
    } else {
      first = num3;
      if (num1 < num2) {
        second = num1;
        third = num2;
      } else {
        second = num2;
        third = num1;
      }
    }

    System.out.printf("%f, %f, %f%n", first, second, third);

  }
}
