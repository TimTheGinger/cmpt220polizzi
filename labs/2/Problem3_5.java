import java.util.Scanner;

public class Problem3_5 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); //Create scanner

    System.out.print("Enter today's day: "); //Prompt user input
    int todayNum = scan.nextInt();

    System.out.print("Enter the number of days elapsed since today: "); //Prompt user input #2
    int futureNum = scan.nextInt();

    int futureDayNum = (todayNum + futureNum) % 7; //Calculate future day number

    System.out.println(
        "Today is " + getDayOfWeek(todayNum) + " and the future day is " + getDayOfWeek(
            futureDayNum));
  }

  private static String getDayOfWeek(int dayNum) {
    switch (dayNum) {
      case 0:
        return "Sunday";
      case 1:
        return "Monday";
      case 2:
        return "Tuesday";
      case 3:
        return "Wednesday";
      case 4:
        return "Thursday";
      case 5:
        return "Friday";
      case 6:
        return "Saturday";
      default:
        System.out.println("Something went wrong");
        return "Failure";
    }
  }
}
