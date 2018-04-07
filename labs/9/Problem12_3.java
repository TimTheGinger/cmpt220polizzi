import java.util.*;

public class Problem12_3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[100];
    String nextScanned = "";

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 100);
    }

    System.out.println("To exit the program, type \"quit\"");
    System.out.println("Enter an index in the array to be printed: ");
    while (!nextScanned.equals("quit")) {
      try {
        nextScanned = scan.next();
        System.out.println(arr[Integer.parseInt(nextScanned)]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Out of Bounds");
      }
    }
  }
}

