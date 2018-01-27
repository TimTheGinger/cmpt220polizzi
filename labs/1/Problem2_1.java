import java.util.Scanner;

public class Problem2_1 {

  public static void main(String[] args) {
    Scanner scan =  new Scanner(System.in);

    System.out.println("Insert Celsius degree (in double):");

    Double celsius = scan.nextDouble();

    Double fahrenheit = (9.0 / 5.0) * celsius + 32.0;

    System.out.println(fahrenheit);
  }
}
