import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Problem7_3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the integers between 1 and 100: ");

    Map<Integer, Integer> scanMap = new TreeMap();
    int nextInt = scan.nextInt();
    int counter = 0;

    while (nextInt != 0 && counter < 100) {
      counter++;

      if (scanMap.containsKey(nextInt)) {
        scanMap.put(nextInt, scanMap.get(nextInt) + 1);
      } else {
        scanMap.put(nextInt, 1);
      }

      nextInt = scan.nextInt();
    }

    for (Integer key : scanMap.keySet()) {
      System.out.printf("%d occurs %d times%n", key, scanMap.get(key));
    }
  }
}
