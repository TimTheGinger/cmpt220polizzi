import java.util.Scanner;

public class Problem6_17 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter how large you would like the matrix to be: ");
    int n = scan.nextInt();

    printMatrix(n);
  }

  /**
   * Prints a matrix of n x n size
   *
   * @param n The length and height of the matrix
   */
  public static void printMatrix(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%d\t", randNum());
      }
      System.out.println();
    }
  }

  /**
   * Generates a random number of either 0 or 1
   *
   * @return 0 or 1
   */
  private static int randNum() {
    double randDub = Math.random();

    if (randDub > 0.45) {
      return 1;
    } else {
      return 0;
    }
  }
}
