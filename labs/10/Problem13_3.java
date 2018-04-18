import java.util.*;

public class Problem13_3 {

  public static void main(String[] args) {
    ArrayList<Number> numList = new ArrayList();
    numList.add(12);
    numList.add(10);
    numList.add(22);
    numList.add(55);
    numList.add(9);

    for (Number num : numList) {
      System.out.print(num.doubleValue() + " ");
    }
    System.out.println("\n");
    sort(numList);
    for (Number num : numList) {
      System.out.print(num.doubleValue() + " ");
    }
  }

  public static void sort(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i).doubleValue() > list.get(j).doubleValue()) {
          Number temp = list.get(j);
          list.set(j, list.get(i));
          list.set(i, temp);
        }
      }
    }
  }

}
