package problem9_11;

/**
 * Creates a new linear equation object to solve
 */
public class LinearEquation {

  private double a, b, c, d, e, f;

  /**
   * Constructs a new linear equation
   *
   * @param a The variable a
   * @param b The variable b
   * @param c The variable c
   * @param d The variable d
   * @param e The variable e
   * @param f The variable f
   */
  public LinearEquation(double a, double b, double c, double d, double e, double f) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.f = f;
  }

  /**
   * Gets the value of a
   *
   * @return The value of a
   */
  public double getA() {
    double tempA = a;
    return tempA;
  }

  /**
   * Gets the value of b
   *
   * @return The value of b
   */
  public double getB() {
    double tempB = b;
    return tempB;
  }

  /**
   * Gets the value of c
   *
   * @return The value of c
   */
  public double getC() {
    double tempC = c;
    return tempC;
  }

  /**
   * Gets the value of d
   *
   * @return The value of d
   */
  public double getD() {
    double tempD = d;
    return tempD;
  }

  /**
   * Gets the value of e
   *
   * @return The value of e
   */
  public double getE() {
    double tempE = e;
    return tempE;
  }

  /**
   * Gets the value of f
   *
   * @return The value of f
   */
  public double getF() {
    double tempF = f;
    return tempF;
  }

  /**
   * Determines if the problem is solveable
   *
   * @return True if it can be solved, false otherwise
   */
  public boolean isSolvable() {
    if ((a * d) - (b * c) != 0) {
      return true;
    }
    return false;
  }

  /**
   * Solves the problem for x
   *
   * @return The value of x
   */
  public double getX() {
    double top = (e * d) - (b * f);
    double bottom = (a * d) - (b * c);

    return top / bottom;
  }

  /**
   * Solves the problem for y
   *
   * @return The value of y
   */
  public double getY() {
    double top = (a * f) - (e * c);
    double bottom = (a * d) - (b * c);

    return top / bottom;
  }
}
