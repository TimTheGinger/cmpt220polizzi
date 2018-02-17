public class Problem6_9 {

  public static void main(String[] args) {
    System.out.println("Feet\t Meters\t|\t Meters\t Feet");
    System.out.println("–––––––––––––––––––––––––––––");

    for (double i = 1; i <= 10; i++) {
      double meterIncr = 15 + (i * 5);
      System.out.printf("%-10f %-10f | %-10f %-10f%n", i, footToMeter(i), meterIncr,
          meterToFoot(meterIncr));
    }
  }

  /**
   * Convert from feet to meters.
   *
   * @param foot The amount of feet you want to convert to meters
   * @return The amount of meters converted from feet
   */
  public static double footToMeter(double foot) {
    final double CONVERSION = 0.305;
    return CONVERSION * foot;
  }

  /**
   * Converts from meters to feet.
   *
   * @param meter The amount of meters you want to convert to feet
   * @return The amount of feet converted from meters
   */
  public static double meterToFoot(double meter) {
    final double CONVERSION = 3.279;
    return CONVERSION * meter;
  }
}
