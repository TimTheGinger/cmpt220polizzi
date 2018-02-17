import java.util.Scanner;

public class Problem7_9 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter 10 numbers: ");
    double[] scanArray = new double[10];

    for (int i = 0; i < scanArray.length; i++) {
      scanArray[i] = scan.nextDouble();
    }

    System.out.println("The minimum number is " + min(scanArray));
  }

  /**
   * Finds the smallest number in the array
   *
   * @param array The array to have the smallest number found
   * @return The smallest number in array
   */
  private static double min(double[] array) {
    double currentSmallest = array[0];

    for (int i = 1; i < array.length; i++) {
      if (array[i] < currentSmallest) {
        currentSmallest = array[i];
      }
    }

    return currentSmallest;
  }
}
