import java.util.*;

public class Problem7_15 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Please input 10 numbers: ");
    int[] inputList = new int[10];

    for (int i = 0; i < 10; i++) {
      inputList[i] = scan.nextInt();
    }

    System.out
        .println("The distinct numbers are: " + arrayToString(eliminateDuplicates(inputList)));
  }

  /**
   * Returns a new array containing only unique numbers from the original array
   *
   * @param list The original array to be scanned
   * @return The new array of only unique numbers
   */
  private static int[] eliminateDuplicates(int[] list) {
    int[] listCopy = list.clone();
    int size = list.length;

    for (int i = 0; i < list.length; i++) {
      boolean delete = false;

      for (int j = i + 1; j < list.length; j++) {
        if (list[i] == list[j]) {
          delete = true;
        }
      }

      if (delete) {
        listCopy[i] = 0;
        size--;
      }
    }

    int[] newList = new int[size];

    int x = 0;
    int y = 0;
    while (x < size) {
      if (listCopy[y] != 0) {
        newList[x] = listCopy[y];
        x++;
      }
      y++;
    }

    return newList;
  }

  /**
   * Converts an array into a string
   *
   * @param arr The array to be converted into a string
   * @return The string representation of the array
   */
  private static String arrayToString(int[] arr) {
    String str = "";

    for (int i = 0; i < arr.length; i++) {
      str += arr[i] + " ";
    }

    return str;
  }
}
