import java.util.Scanner;

public class A1Paper {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    /*
    Obtains first integer, size 2 <= n <= 30
    This is the min A number, the smallest A size of the papers
    (This is how large the paper is. The larger the number, the smaller the size)
     */

    boolean aNumCheck = true; // Checks to see if the first line is a valid input
    int aNum = -1;

    while (aNumCheck) {
      aNum = scan.nextInt();
      aNumCheck = false;

      if (aNum < 2 || aNum > 30) {
        System.out.println("Please input a number in range (2 <= n <= 30): ");
        aNumCheck = true;
      }
    }

    // The array in which the amount of a given paper size is stored
    int[] numArray = new int[aNum - 1];

    /*
    Loops through second line aNum - 1 times. This is the number of sheet of paper per A size,
     starting at A2. This will continue up to An (n being aNum). There will be no more than
     10^9 of any one size of paper.
     */
    for (int i = 0; i < numArray.length; i++) {
      Integer temp = scan.nextInt();
      numArray[i] = temp;
    }

    if (!a1Check(numArray)) {
      System.out.println("impossible");
    } else {
      System.out.print(tapeLength(numArray));
    }

  }

  /**
   * Checks if it is possible to make the pieces of paper into an A1 piece of paper.
   *
   * @param arr The array containing the sizes and amounts of all papers.
   * @return True if it is possible to make the papers into an A1 size piece of paper, otherwise
   * return false.
   */
  private static boolean a1Check(int[] arr) {
    final double goal = 1000;
    double runningSum = 0;

    for (int i = 0; i < arr.length; i++) {
      /*
      Takes the endpoint (goal), divides by the value of the index of the number and then multiplies
      by the number of papers.
      */
      runningSum += (goal / (Math.pow(2, i + 1)) * arr[i]);
    }

    if (runningSum >= goal) {
      return true;
    }
    return false;
  }

  /**
   * Gets the length of tape necessary to make the paper into an A1 piece of paper.
   *
   * @param arr The array containing the sizes and amounts of all papers.
   * @return The length of tape needed to make the papers into an A1 piece of paper.
   */
  private static double tapeLength(int[] arr) {
    double[] paperSizes = getNecessary(arr);

    int papersLength = paperSizes.length;

    if(papersLength % 2 != 0)
      papersLength--;

    final double a2Long = 0.42044820762;
    final double a2Short = 0.5946035575;

    double iLong = a2Short / Math.pow(2, (paperSizes.length - 2)/2);
    double iShort = a2Long / Math.pow(2, (paperSizes.length - 2)/2);

    double runningSum = 0;

    for(int i = paperSizes.length-1; i > 1; i--){
      double addTogether = paperSizes[i]/2;
      runningSum = iLong * addTogether;
      paperSizes[i-1] += addTogether;

      double temp = iShort;
      iShort = iLong;
      iLong = temp * 2;
    }

    return runningSum + a2Long;
  }

  /**
   * Gets the necessary amounts of papers from an array and returns them
   *
   * @param arr The array of papers that needs to be trimmed
   * @return The trimmed array of papers
   */
  private static double[] getNecessary(int[] arr) {
    final double goal = 1000;
    double runningSum = 0;

    double[] tempArr = new double[arr.length];

    for (int i = 0; runningSum < goal; i++) {
      // The value of item i in arr, half of the previous value
      double valueOfI = goal / (Math.pow(2, i + 1));

      if (valueOfI * arr[i] > goal - runningSum) {
        double temp = (goal - runningSum) / valueOfI;
        tempArr[i] = temp;
        runningSum += temp * valueOfI;
      } else {
        tempArr[i] = arr[i];
        runningSum += valueOfI * arr[i];
      }
    }

    return tempArr;
  }
}
