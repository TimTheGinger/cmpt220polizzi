public class Problem6_13 {

  public static void main(String[] args) {
    System.out.println("i\t\t\t\t\t | m(i)");
    System.out.println("–––––––––––––––––––––––––––––");

    for (int i = 1; i <= 20; i++) {
      System.out.printf("%-10d | %-10f%n", i, summation(i));
    }
  }

  /**
   * Takes the summation of toSum, in the format of i / (i + 1), where i is toSum.
   *
   * @param toSum The ending point of the loop of summation
   * @return The summation of i / (i + 1), where i is toSum.
   */
  private static double summation(double toSum) {
    double runningSum = 0;

    for (double i = 1; i <= toSum; i++) {
      runningSum += i / (i + 1);
    }

    return runningSum;
  }
}
