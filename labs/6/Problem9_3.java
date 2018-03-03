import java.util.*;

public class Problem9_3 {

  public static void main(String[] args) {
    Date dateObj = new Date();

    for (int i = 4; i <= 11; i++) {
      dateObj.setTime((long) Math.pow(10, i));
      System.out.println(dateObj.toString());
    }

  }

}
