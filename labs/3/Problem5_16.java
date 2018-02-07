import java.util.Scanner;

public class Problem5_16 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int input = scan.nextInt();

    int half = input / 2;
    int incr = 2;

    while (incr < half) {
      if (input % incr == 0) {
        System.out.print(incr + ",");
        input /= incr;
      } else {
        incr++;
      }

    }
  }
}
