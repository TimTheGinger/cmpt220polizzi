//package Problem11_1;

import java.util.Scanner;

public class TriangleTester {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter three (3) sides of the Triangle");
    Double side1 = scan.nextDouble();
    Double side2 = scan.nextDouble();
    Double side3 = scan.nextDouble();

    System.out.print("Is the triangle filled with a color? Please enter True or False: ");
    boolean filled = scan.nextBoolean();

    Triangle newTriangle;

    if (filled) {
      System.out.print("What color is the triangle filled with: ");
      String color = scan.next();

      newTriangle = new Triangle(side1, side2, side3, color, filled);
    } else {
      newTriangle = new Triangle(side1, side2, side3);
    }

    System.out.println(
        "\n" + newTriangle.toString() + "\nArea: " + newTriangle.getArea() + "\nPerimeter: "
            + newTriangle.getPerimiter());
  }
}
