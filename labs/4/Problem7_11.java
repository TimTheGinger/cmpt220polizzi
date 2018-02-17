import java.util.Scanner;

public class Problem7_11 {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter 10 numbers: ");

    double[] doubleArray = new double[10];

    for(int i = 0; i < 10; i++){
      doubleArray[i] = scan.nextDouble();
    }

    System.out.println("The mean is " + mean(doubleArray));
    System.out.println("The deviation is " + deviation(doubleArray));
  }

  /**
   * Compute the deviation of the double values
   * @param x The double values to compute
   * @return The deviation of the double values, x
   */
  private static double deviation(double[] x){
    double sum = 0;
    double mean = mean(x);

    for(int i = 0; i < x.length; i++){
      sum += Math.pow(x[i] - mean, 2);
    }

    return Math.sqrt(sum / (x.length - 1));
  }

  /**
   * Compute the mean of an array of double values
   * @param x The double values that are to be computed
   * @return The mean of the double values, x
   */
  private static double mean(double[] x){
    double sum = 0;

    for(int i = 0; i < x.length; i++){
      sum += x[i];
    }

    return sum / x.length;
  }
}
