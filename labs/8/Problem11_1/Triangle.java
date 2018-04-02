package Problem11_1;

public class Triangle extends GeometricObject {

  private double side1 = 1.0;
  private double side2 = 1.0;
  private double side3 = 1.0;

  /**
   * Generates a basic Triangle with default sides of length 1
   */
  public Triangle() {
    super();
  }

  /**
   * Generates a basic Triangle with default values and an internal color
   *
   * @param color The color of the triangle
   * @param filled Is the triangle filled with the color
   */
  public Triangle(String color, boolean filled) {
    super(color, filled);
  }

  /**
   * Generates a basic Triangle with specified side lengths
   *
   * @param side1 The length of side 1
   * @param side2 The length of side 2
   * @param side3 The length of side 3
   */
  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  /**
   * Generates a basic Triangle with specified side lengths and a color if it is filled
   *
   * @param side1 The length of side 1
   * @param side2 The length of side 2
   * @param side3 The length of side 3
   * @param color The color the triangle is filled with
   * @param filled Is the triangle filled with color
   */
  public Triangle(double side1, double side2, double side3, String color, boolean filled) {
    super(color, filled);
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  /**
   * Gets the length of side 1
   *
   * @return The double length of side 1
   */
  public double getSide1() {
    return side1;
  }

  /**
   * Gets the length of side 2
   *
   * @return The double length of side 2
   */
  public double getSide2() {
    return side2;
  }

  /**
   * Gets the length of side 3
   *
   * @return The double length of side 3
   */
  public double getSide3() {
    return side3;
  }

  /**
   * Gets the area of the triangle using the 3 given sides
   *
   * @return The area of the triangle
   */
  public double getArea() {
    double temp = (side1 + side2 + side3) / 2;
    return Math.sqrt(temp * (temp - side1) * (temp - side2) * (temp - side3));
  }

  /**
   * Gets the perimeter of the triangle using the 3 given sides
   *
   * @return The perimeter of the triangle
   */
  public double getPerimiter() {
    return side1 + side2 + side3;
  }

  /**
   * Returns the String representation of the triangle object
   *
   * @return the String representation of the triangle object
   */
  public String toString() {
    String toString =
        super.toString() + "\nTriangle: side1 = " + side1 + " side2 = " + side2 + " side3 = "
            + side3;
    ;
    return toString;
  }
}
