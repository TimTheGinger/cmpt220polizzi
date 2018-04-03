package Problem11_11;

import java.util.*;

public class MainMethodSort {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter 5 integers:");
    ArrayList<Integer> intList = new ArrayList();

    for (int i = 0; i < 5; i++) {
      intList.add(scan.nextInt());
    }

    sort(intList);
  }

  public static void sort(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) > list.get(j)) {
          int temp = list.get(j);
          list.set(j, list.get(i));
          list.set(i, temp);
        }
      }
    }

    for (int index = 0; index < list.size(); index++) {
      System.out.print(list.get(index) + " ");
    }
  }

}
