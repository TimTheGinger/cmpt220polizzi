import java.util.Stack;
import java.util.Scanner;

public class Problem8_11 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean cont = true;
    int scannedNumber = 0;

    while (cont) {
      System.out.print("Enter a number between 0 and 511: ");
      scannedNumber = scan.nextInt();

      if (scannedNumber > 511) {
        System.out.print("Please enter a valid number");
      } else {
        cont = false;
      }
    }

    arrayPrinter(binaryToArray(decimalToBinary(scannedNumber)));
  }

  /**
   * Converts a binary number into a 3x3 array containing H and T, H for 0 and T for 1
   *
   * @param binary The binary number to be converted
   * @return The array containing the array of H and Ts
   */
  private static String[][] binaryToArray(String binary) {
    String[][] hOrTArray = new String[3][3];
    int iter = 0;

    for (int i = 0; i < hOrTArray.length; i++) {
      for (int j = 0; j < hOrTArray[0].length; j++) {
        String hOrT;
        int nextNum = Integer.parseInt(binary.substring(iter, iter + 1));

        if (nextNum == 0) {
          hOrT = "H";
        } else {
          hOrT = "T";
        }

        hOrTArray[i][j] = hOrT;
        iter++;
      }
    }

    return hOrTArray;
  }

  /**
   * Converts a decimal to a binary number with 7 digits
   *
   * @param num The decimal to be converted
   * @return The binary representation of the decimal number with 7 digits
   */
  private static String decimalToBinary(int num) {
    Stack binaryStack = new Stack();
    int numCopy = num;

    while (numCopy > 0) {
      int toPush = numCopy % 2;
      binaryStack.push(toPush);
      numCopy /= 2;
    }

    String binaryString = "";

    while (!binaryStack.empty()) {
      binaryString += binaryStack.pop() + "";
    }

    for (int i = binaryString.length(); i < 9; i++) {
      String temp = binaryString;
      binaryString = "0" + temp;
    }

    return binaryString;
  }

  /**
   * Prints out an array
   *
   * @param arr The array of Strings to be printed
   */
  private static void arrayPrinter(String[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
