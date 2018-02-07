import java.util.Scanner;

public class Problem5_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter an integer, the input ends if it is 0: ");

    int input = scan.nextInt();

    int posCount = 0;
    int negCount = 0;
    double total = 0;
    double count = 0;

    while (input != 0) {
      count++; // each iteration count increments

      if (input > 0) { // if a number is divisible by 2 its even
        posCount++;
      } else { // otherwise it is odd
        negCount++;
      }

      total += input; // a running sum

      input = scan.nextInt();
    }

    double avg = total / count;

    if (count < 1) {
      System.out.println("no numbers are entered except 0");
    } else {
      System.out.println("The number of positives is " + posCount);
      System.out.println("The number of negatives is " + negCount);
      System.out.println("The total is " + total);
      System.out.println("The average is " + avg);
    }

  }

}
