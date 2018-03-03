import java.util.*;

public class Problem9_5 {

  public static void main(String[] args) {
    GregorianCalendar gCal = new GregorianCalendar();

    System.out.println(
        gCal.get(GregorianCalendar.YEAR) + ", " + gCal.get(GregorianCalendar.MONTH) + " " + gCal
            .get(GregorianCalendar.DAY_OF_MONTH));

    gCal.setTimeInMillis(1234567898765L);

    System.out.println(
        gCal.get(GregorianCalendar.YEAR) + ", " + gCal.get(GregorianCalendar.MONTH) + " " + gCal
            .get(GregorianCalendar.DAY_OF_MONTH));
  }

}
