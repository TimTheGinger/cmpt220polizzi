//package problem9_13;

import java.util.*;

public class LocationTester {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the number of rows and columns in the array: ");
    int rows = scan.nextInt();
    int cols = scan.nextInt();

    System.out.println("Enter the array:");
    double[][] userArray = new double[rows][cols];

    for (int i = 0; i < userArray.length; i++) {
      for (int j = 0; j < userArray[i].length; j++) {
        userArray[i][j] = scan.nextDouble();
      }
    }

    Location largest = locateLargest(userArray);

    System.out.println(
        "The location of the largest element is " + largest.maxValue + " at (" + largest.row + ", "
            + largest.column + ")");
  }

  /**
   * Locates the laregest item in a 2D array
   *
   * @param a The 2D array to be searched
   * @return The largest item in the array and its location
   */
  public static Location locateLargest(double[][] a) {
    Location biggest = new Location();
    biggest.row = 0;
    biggest.column = 0;
    biggest.maxValue = a[0][0];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > biggest.maxValue) {
          biggest.maxValue = a[i][j];
          biggest.row = i;
          biggest.column = j;
        }
      }
    }

    return biggest;
  }
}
