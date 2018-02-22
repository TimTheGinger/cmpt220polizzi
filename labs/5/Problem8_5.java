import java.util.Scanner;

public class Problem8_5 {

  public static void main(String[] args) {
    System.out.print("Enter matrix1: ");

    double[][] matrix1 = generateMatrix(3, 3);

    System.out.print("Enter matrix2: ");

    double[][] matrix2 = generateMatrix(3, 3);

    System.out.println("The matrices are added as follows");

    arrayAdditionPrinter(matrix1, matrix2);
  }

  /**
   * Checks if two matrices are possible to add together
   *
   * @param matrix1 The first matrix to check
   * @param matrix2 The second matrix to check
   * @return True if the matrices can be added, false otherwise
   */
  private static boolean isAddable(double[][] matrix1, double[][] matrix2) {
    if (matrix1.length == matrix2.length) {
      for (int i = 0; i < matrix1.length; i++) {
        if (matrix1[i].length == matrix2[i].length) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Generates a new matrix of length and width with user inputted for its internal values
   *
   * @param length The first size specification in the matrix
   * @param width The second size specification in the matrix
   * @return A new matrix of length x width full of user inputted values
   */
  private static double[][] generateMatrix(int length, int width) {
    Scanner matrixScanner = new Scanner(System.in);
    double[][] newMatrix = new double[length][width];

    for (int i = 0; i < newMatrix.length; i++) {
      for (int j = 0; j < newMatrix[i].length; j++) {
        newMatrix[i][j] = matrixScanner.nextDouble();
      }
    }

    return newMatrix;
  }

  /**
   * Prints out two matrices added together and their sum
   *
   * @param matrix1 The first matrix to add
   * @param matrix2 The second matrix to add
   */
  private static void arrayAdditionPrinter(double[][] matrix1, double[][] matrix2) {
    double[][] sumMatrix = addMatrix(matrix1, matrix2);

    for (int i = 0; i < matrix1.length; i++) {
      for (int m1 = 0; m1 < matrix1[i].length; m1++) {
        System.out.printf("%.1f\t", matrix1[i][m1]);
      }

      if (i == (int) ((matrix1.length / 2) + .5)) {
        System.out.print("+ ");
      } else {
        System.out.print("\t");
      }

      for(int m2 = 0; m2 < matrix2[i].length; m2++){
        System.out.printf("%.1f\t", matrix2[i][m2]);
      }

      if (i == (int) ((matrix1.length / 2) + .5)) {
        System.out.print("= ");
      } else {
        System.out.print("\t");
      }

      for(int m3 = 0; m3 < sumMatrix[i].length; m3++){
        System.out.printf("%.1f\t", sumMatrix[i][m3]);
      }

      System.out.println();

    }
  }

  /**
   * Adds together matrices a and b and returns their sum
   *
   * @param a The first matrix to be added
   * @param b The second matrix to be added
   * @return The sum of matrix a and b
   */
  private static double[][] addMatrix(double[][] a, double[][] b) {
    if (!isAddable(a, b)) {
      System.out.println("Not possible to add");
      return null;
    }

    double[][] c = new double[a.length][a[0].length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }

    return c;
  }

}
