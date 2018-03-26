//package Problem10_3;

import java.lang.Math;

public class MyInteger {

  //stores the int value represented by MyInteger
  private int value;

  /**
   * Basic constructor, sets an integer value to MyInteger
   *
   * @param val The integer value of the MyInteger object
   */
  public MyInteger(int val) {
    value = val;
  }

  /**
   * Gets the integer value of this MyInteger object
   *
   * @return The integer value of this MyInteger object
   */
  public int getValue() {
    int temp = value;

    return temp;
  }

  /**
   * Checks if the integer value of this MyInteger is even
   *
   * @return True if the integer is even, false otherwise
   */
  public boolean isEven() {
    if (value % 2 == 0) {
      return true;
    }
    return false;
  }

  /**
   * Checks if the integer value of val is even
   *
   * @return True if the number is even, false otherwise
   */
  public static boolean isEven(int val) {
    MyInteger temp = new MyInteger(val);

    return temp.isEven();
  }

  /**
   * Checks if the integer value of the MyInteger val is even
   *
   * @return True if the number is even, false otherwise
   */
  public static boolean isEven(MyInteger val) {
    return val.isEven();
  }

  /**
   * Checks if the integer value of this MyInteger is odd
   *
   * @return True if the number is odd, false otherwise
   */
  public boolean isOdd() {
    if (value % 2 != 0) {
      return true;
    }
    return false;
  }

  /**
   * Checks if the integer value of val is odd
   *
   * @return True if the number is odd, false otherwise
   */
  public static boolean isOdd(int val) {
    MyInteger temp = new MyInteger(val);

    return temp.isOdd();
  }

  /**
   * Checks if the integer value of the MyInteger val is odd
   *
   * @return True if the number is odd, false otherwise
   */
  public static boolean isOdd(MyInteger val) {
    return val.isOdd();
  }

  /**
   * Checks if the integer value of this MyInteger is prime
   *
   * @return True if the number is prime, false otherwise
   */
  public boolean isPrime() {
    if (value < 2) {
      return true;
    }

    if (value % 2 == 0) {
      return false;
    }

    int root = (int) Math.sqrt((double) value);

    for (int i = 3; i <= root; i += 2) {
      if (value % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the integer value of val is prime
   *
   * @return True if the number is prime, false otherwise
   */
  public static boolean isPrime(int val) {
    MyInteger temp = new MyInteger(val);

    return temp.isPrime();
  }

  /**
   * Checks if the integer value of the MyInteger val is prime
   *
   * @return True if the number is prime, false otherwise
   */
  public static boolean isPrime(MyInteger val) {
    return val.isPrime();
  }

  /**
   * Checks if the integer value of this MyInteger is equal to another integer
   *
   * @param val The integer to be compared against
   * @return True if the integer values of val and this MyInteger are equal, false otherwise
   */
  public boolean equals(int val) {
    if (val == value) {
      return true;
    }
    return false;
  }

  /**
   * Checks if the integer value of this MyInteger is equal to another MyInteger
   *
   * @param val The MyInteger to be compared against
   * @return True if the integer values of val and this MyInteger are equal, false otherwise
   */
  public boolean equals(MyInteger val) {
    if (val.getValue() == value) {
      return true;
    }
    return false;
  }

  /**
   * Converts an array of char values into an integer
   *
   * @param toParse The array of char values
   * @return the integer representation of toParse
   */
  public static int parseInt(char[] toParse) {
    return Integer.valueOf(String.valueOf(toParse));
  }

  /**
   * Converts a String into an integer
   *
   * @param toParse The string representation of a integer
   * @return the integer representation of toParse
   */
  public static int parseInt(String toParse) {
    return Integer.valueOf(toParse);
  }
}
