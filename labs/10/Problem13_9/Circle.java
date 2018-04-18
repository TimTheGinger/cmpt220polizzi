package Problem13_9;

public class Circle extends GeometricObject13_9 implements Comparable{

  private double radius;

  /**
   * Generates a new Circle with a radius of 1
   */
  public Circle() {
    radius = 1;
  }

  /**
   * Generates a new Circle object with a specified radius
   *
   * @param radius the radius of the circle
   */
  public Circle(double radius) {
    this.radius = radius;
  }

  /**
   * Generates a new Circle object that is a subclass of GeometricObject
   *
   * @param radius The radius of the generated circle
   * @param color The color of the generated circle
   * @param filled True if the circle is supposed to be filled with color, false otherwise
   */
  public Circle(double radius, String color, boolean filled) {
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }

  /**
   * Gets the radius of the circle
   *
   * @return The radius
   */
  public double getRadius() {
    return radius;
  }

  /**
   * Sets the radius of the circle
   *
   * @param radius The new radius of the circle
   */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /**
   * Gets the diameter of the circle
   *
   * @return 2 times the radius
   */
  public double getDiameter() {
    return radius * 2;
  }

  /**
   * Gets the area of the shape
   *
   * @return the area
   */
  public double getArea() {
    return 0;
  }

  /**
   * Gets the perimeter of the shape
   *
   * @return the perimeter
   */
  public double getPerimeter() {
    return 0;
  }

  /**
   * Compares the radius of this circle and another one to see if they're equal
   * @param c the other circle to be compared
   * @return
   */
  public boolean equals(Circle c){
    if(radius == c.getRadius())
      return true;
    return false;
  }

  /**
   * Compares this Circle to another based on radii
   * @param o The other circle to be compared
   * @return whether or not this is equal to another object
   */
  public int compareTo(Object o) {
    if(this.hashCode() > o.hashCode())
      return 1;
    else if(this.hashCode() <  o.hashCode())
      return -1;
    else return 0;
  }
}
