import java.util.Scanner;

public class Problem2_5 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the subtotal and a gratuity rate: ");

    double subtotal = scan.nextDouble();
    double gratuity = scan.nextDouble() / 100;

    double tip = subtotal * gratuity;
    double total = tip + subtotal;

    System.out.println("The gratuity is $" + tip + " and the total is $" + total);
  }
}
