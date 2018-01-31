import java.math.RoundingMode;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Problem4_23 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter employee's name: "); //prompt name
    String name = scan.next(); //scan name

    System.out.print("Enter number of hours worked in a week: "); //prompt hours
    double hours = scan.nextDouble(); //scan hours

    System.out.print("Enter hourly pay rate: "); //prompt rate
    double rate = scan.nextDouble(); //scan rate

    System.out.print("Enter federal tax withholding rate: "); //prompt fedWith
    double fedWith = scan.nextDouble(); //scan fedWith

    System.out.print("Enter state tax withholding rate: "); //prompt stWith
    double stWith = scan.nextDouble(); //scan stWith

    double grossPay = hours * rate; //pay before tax

    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.FLOOR);

    double fedPercent = fedWith * 100;
    //attempt to calculate the amount of money the federal government gets, and then round it to 2 decimals
    double fedMoney = new Double(df.format(grossPay * fedWith));

    double stPercent = stWith * 100;
    //attempt to calculate the amount of money the state gets, and then round it to 2 decimals
    double stMoney = new Double(df.format(grossPay * stWith));

    double totalDeduction = Math.floor((fedMoney + stMoney) * 100) / 100;
    double netPay = grossPay - totalDeduction;

    System.out.println(
        "\nEmployee Name: " + name + "\nHours Worked: " + hours + "\nPay Rate: $" + rate
            + "\nGross Pay: $" + grossPay);
    System.out.println("Deductions: \n\tFederal Withholding (" + fedPercent + "%): $" + fedMoney
        + "\n\tState Withholding (" + stPercent + "%): $" + stMoney + "\n\tTotal Deduction: $"
        + totalDeduction);
    System.out.println("Net Pay: $" + netPay);
  }

}
