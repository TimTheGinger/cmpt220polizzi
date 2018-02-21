import java.util.Scanner;

public class Problem8_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter a 3x4 matrix row by row:");
    double[][] matrix = new double[3][4];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = scan.nextInt();
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      System.out.println("Sum of the elements at column " + i + " is " + sumColumn(matrix, i));
    }
  }

  /**
   * Return the sum of a column in a a matrix, m
   *
   * @param m The matrix of values
   * @param columnIndex The index of the column to be summed
   * @return The sum of the selected column in the matrix
   */
  private static double sumColumn(double[][] m, int columnIndex) {
    double runningSum = 0;

    for (int i = 0; i < m.length; i++) {
      runningSum += m[i][columnIndex];
    }

    return runningSum;
  }

}
