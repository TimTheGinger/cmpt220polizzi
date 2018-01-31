import java.time.YearMonth;
import java.util.Scanner;

public class Problem3_11 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Month? "); //prompt user input
    int mth = scan.nextInt(); //scan user input

    System.out.print("Year? "); //prompt user input
    int yr = scan.nextInt(); //scan user input

    YearMonth date = YearMonth.of(yr, mth);
    int maxDays = date.lengthOfMonth(); //getting the number of days in a month

    //Output (date.getMonth() works as well)
    System.out.println(getMonth(mth) + " " + date.getYear() + " has " + maxDays + " days.");

  }

  private static String getMonth(int monthNum) {
    String month;

    switch (monthNum) {
      case 1:
        month = "January";
        break;
      case 2:
        month = "February";
        break;
      case 3:
        month = "March";
        break;
      case 4:
        month = "April";
        break;
      case 5:
        month = "May";
        break;
      case 6:
        month = "June";
        break;
      case 7:
        month = "July";
        break;
      case 8:
        month = "August";
        break;
      case 9:
        month = "September";
        break;
      case 10:
        month = "October";
        break;
      case 11:
        month = "November";
        break;
      case 12:
        month = "December";
        break;
      default:
        month = "FAILURE";
    }

    return month;
  }
}
