import java.util.Scanner;

public class Problem6_19 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter three sides to a triangle: ");

    double side1 = scan.nextDouble();
    double side2 = scan.nextDouble();
    double side3 = scan.nextDouble();

    if(!isValid(side1, side2, side3))
      System.out.println("This is an invalid triangle");
    else
      System.out.println(area(side1, side2, side3));
  }

  /**
   * Return true if the sum of every two sides is greater than the third side
   * @param side1 The first side to check
   * @param side2 The second side to check
   * @param side3 The third side to check
   * @return Whether or not the triangle is valid
   */
  private static boolean isValid(double side1, double side2, double side3){
    boolean success = true;

    if(side1 +  side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2)
      success = false;

    return success;
  }

  /**
   * Returns the area of the triangle
   * @param side1 The first side
   * @param side2 The second side
   * @param side3 The third side
   * @return The area of the triangle
   */
  private static double area(double side1, double side2, double side3){
    double s = (side1 + side2 + side3) / 2;

    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }
}
