//package problem9_11;

import java.util.*;

public class LinearEquationTester {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    double[] scanNums = new double[6];

    for (int i = 0; i < scanNums.length; i++) {
      scanNums[i] = scan.nextDouble();
    }

    LinearEquation uiEquation = new LinearEquation(scanNums[0], scanNums[1], scanNums[2],
        scanNums[3], scanNums[4], scanNums[5]);

    if (!uiEquation.isSolvable()) {
      System.out.println("The equation has no solution.");
    } else {
      System.out.println("X = " + uiEquation.getX());
      System.out.println("Y = " + uiEquation.getY());
    }
  }

}
