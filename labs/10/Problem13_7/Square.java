package Problem13_7;

public class Square extends GeometricObject13_7 implements Colorable {

  private double side;

  /**
   * Generates a default square object with a side length of 0
   */
  public Square() {
    side = 0;
  }

  /**
   * Gets the area of the Square
   *
   * @return the area of the Square
   */
  public double getArea() {
    return Math.pow(2, side);
  }

  /**
   * Gets the perimeter of the Square
   *
   * @return The perimeter of the Square
   */
  public double getPerimeter() {
    return side * 4;
  }

  /**
   * Generates a square object with a specified side length
   *
   * @param side The length of the side of the square
   */
  public Square(double side) {
    this.side = side;
  }

  public void howToColor() {
    System.out.println("Color all four sides");
  }

  /**
   * Gets the value of side
   */
  public double getSide() {
    return side;
  }

  /**
   * Sets the value of side
   */
  public void setSide(double side) {
    this.side = side;
  }
}
