//package Problem10_11;

/**
 * A class to store and manipulate data of 2D circles
 */
public class Circle2D {

  /**
   * Specifies the center of the circle
   */
  private double x, y;
  /**
   * Radius of the circle
   */
  private double radius;

  /**
   * Constructs the default circle at (0, 0) and a radius of 1
   */
  public Circle2D() {
    x = 0;
    y = 0;
    radius = 1;
  }

  /**
   * Creates a Circle2D object with specified parameters
   *
   * @param x X value of the center of this circle
   * @param y Y value of the center of this circle
   * @param radius Radius of this circle
   */
  public Circle2D(double x, double y, double radius) {

    this.x = x;
    this.y = y;
    this.radius = radius;

  }

  /**
   * @return The X value of the coordinate of this circle
   */
  public double getX() {
    return x;
  }

  /**
   * @return The Y value of the coordinate of this circle
   */
  public double getY() {
    return y;
  }

  /**
   * @return The radius of this circle
   */
  public double getRadius() {
    return radius;
  }

  /**
   * @return Area of this circle
   */
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  /**
   * @return Perimeter of this circle
   */
  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  /**
   * Determines if this circle contains a specified point
   *
   * @param x X coordinate of the point to check
   * @param y Y coordinate of the point to check
   * @return If this circle contains the point
   */
  public boolean contains(double x, double y) {
    if (Math.abs(Math.abs(x) - this.x) > Math.abs(this.x + radius)
        || Math.abs(Math.abs(y) - this.y) > Math.abs(this.y + radius)) {
      return false;
    }
    return true;
  }

  /**
   * Determines if this circle contains another specified circle
   *
   * @param circle Circle to check
   * @return If this circle contains the circle
   */
  public boolean contains(Circle2D circle) {
    if (!this.contains(circle.getX(), circle.getY())) {
      return false;
    }

    return radius >
        Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2)) + circle.radius;
  }

  /**
   * Determines if this circle overlaps with another circle
   *
   * @param circle Circle to check
   * @return If this circle overlaps with the specified circle
   */
  public boolean overlaps(Circle2D circle) {
    if (this.x + this.radius < circle.x + circle.radius
        && this.y + this.radius < circle.y + circle.radius) {
      return false;
    }
    return true;
  }

}