import java.util.Scanner;

public class Problem7_19 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the size of the list: ");
    int size = scan.nextInt();

    System.out.print("Enter the contents of the list: ");

    int[] scanArray = new int[size];
    for (int i = 0; i < size; i++) {
      scanArray[i] = scan.nextInt();
    }

    System.out.println("The list has " + size + " integers " + arrayToString(scanArray));

    System.out.print("The list is ");

    if (isSorted(scanArray)) {
      System.out.print("already sorted.");
    } else {
      System.out.print("not sorted.");
    }

  }

  /**
   * Checks if an array is sorted in ascending order
   *
   * @param list The list to be checked
   * @return True if it is sorted, false otherwise
   */
  private static boolean isSorted(int[] list) {
    boolean sorted = true;

    for (int i = 0; i < list.length - 1; i++) {
      if (list[i + 1] < list[i]) {
        sorted = false;
      }
    }

    return sorted;
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
