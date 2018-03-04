//package problem9_1;

/**
 * A rectangle object
 */
public class Rectangle {

  public double width, height;

  /**
   * The default constructor that sets the width and heights to 1
   */
  public Rectangle() {
    width = 1;
    height = 1;
  }

  /**
   * The implicit constructor that sets the width and height of the rectangle object
   *
   * @param width The width the rectangle is to be set to
   * @param height The height the rectangle is to be set to
   */
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Calculates the area of the rectangle object
   *
   * @return The area of the rectangle object
   */
  public double getArea() {
    return width * height;
  }

  /**
   * Calculates the perimeter of the rectangle object
   *
   * @return The perimeter of the rectangle object
   */
  public double getPerimeter() {
    return (2 * width) + (2 * height);
  }
}
