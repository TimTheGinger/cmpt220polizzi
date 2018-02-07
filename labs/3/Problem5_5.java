public class Problem5_5 {

  public static void main(String[] args) {

    // Base values
    int kiloIncr = 1;
    double lbsConver = 2.2;

    int lbsIncr = 20;
    double kiloConver = 9.09;

    int count = 0;

    System.out.println("Kilograms\t Pounds\t\t\t|\tPounds\t\t Kilograms");
    System.out.printf("%-10d %-10f | %-10d %-10f%n", kiloIncr, lbsConver, lbsIncr, kiloConver);

    while (kiloIncr < 199) {
      kiloIncr += 2;
      lbsConver = 2.2 * kiloIncr;

      lbsIncr += 5;
      kiloConver = lbsIncr / 2.2;

      System.out.printf("%-10d %-10f | %-10d %-10f%n", kiloIncr, lbsConver, lbsIncr, kiloConver);

      count++;
    }
  }
}
