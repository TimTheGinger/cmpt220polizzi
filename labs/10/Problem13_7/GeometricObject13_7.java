package Problem13_7;

public abstract class GeometricObject13_7 {

  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  /**
   * Construct a default geometric object
   */
  protected GeometricObject13_7() {
    dateCreated = new java.util.Date();
  }

  /**
   * Construct a geometric object with the specified color and filled value
   */
  protected GeometricObject13_7(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /**
   * Return color
   */
  public String getColor() {
    return color;
  }

  /**
   * Set a new color
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Return filled. Since filled is boolean, its getter method is named isFilled
   */
  public boolean isFilled() {
    return filled;
  }

  /**
   * Set a new filled
   */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**
   * Get dateCreated
   */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  /**
   * Return a string representation of this object
   */
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
  }

  /**
   * Gets the area of the GeometricObject
   *
   * @return The area of the GeometricObject
   */
  public abstract double getArea();

  /**
   * Gets the perimeter of the GeometricObject
   *
   * @return The area of the GeometricObject
   */
  public abstract double getPerimeter();

}
