import java.util.Scanner;

public class Problem2_7 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the number of minutes: ");

    int min = scan.nextInt();
    int hours = min / 60;
    int days = hours / 24;
    int years = days / 365;
    int remainder = days % 365;

    System.out.println(min + " minutes is approximately " + years + " years and " + remainder + " days");
  }
}
