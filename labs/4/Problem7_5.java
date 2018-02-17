import java.util.TreeMap;
import java.util.Scanner;

public class Problem7_5 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter 10 numbers: ");

    TreeMap<Integer, Integer> numMap = new TreeMap();
    int scannedInt;

    for (int i = 0; i < 10; i++) {
      scannedInt = scan.nextInt();

      if (numMap.containsKey(scannedInt)) {
        numMap.put(scannedInt, numMap.get(scannedInt) + 1);
      } else {
        numMap.put(scannedInt, 1);
      }
    }

    System.out.printf("The number of distinct numbers is %d%n", numMap.keySet().size());

    System.out.println("The distinct numbers are: " + numMap.keySet().toString());
  }
}
