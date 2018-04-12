//package Problem12_5;

public class IllegalTriangleException extends Throwable {
  String errorDesc;

  /**
   * Creates an exception to a triangle, by attempting to create a triangle who's initial bounds
   * exceed the predetermined amount allowed
   */
  public IllegalTriangleException() {
    errorDesc = "The sum of two of a triangle's sides must never exceed the third";
  }

  /**
   * Creates an exception that is described by desc
   *
   * @param desc the description of the exception that has been thrown
   */
  public IllegalTriangleException(String desc) {
    errorDesc = desc;
  }

  public String getMessage(){
    return errorDesc;
  }
}
