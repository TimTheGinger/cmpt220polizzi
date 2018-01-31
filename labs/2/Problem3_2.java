import java.util.Scanner;

public class Problem3_2 {

  public static void main(String[] args) {
    //Three randomly generated numbers
    int num1 = (int) (Math.random() * 10);
    int num2 = (int) (Math.random() * 10);
    int num3 = (int) (Math.random() * 10);

    System.out.println("What is the sum of " + num1 + " + " + num2 + " + " + num3 + "?");

    //user input scanner
    Scanner scan = new Scanner(System.in);
    int ui = scan.nextInt();

    int sum = num1 + num2 + num3;

    //Checks if user was correct, otherwise gives correct answer
    if (ui == sum) {
      System.out.println("Correct!");
    } else {
      System.out.println("The correct answer was " + sum + " try again!");
    }
  }

}
