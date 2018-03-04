//package problem9_1;

public class RectangleTester {

  public static void main(String[] args) {
    Rectangle rect1 = new Rectangle(4, 40);
    Rectangle rect2 = new Rectangle(3.5, 35.9);

    System.out.println("4 x 40 Rectangle:");
    System.out.println(rect1.width);
    System.out.println(rect1.height);
    System.out.println(rect1.getArea());
    System.out.println(rect1.getPerimeter());

    System.out.println("3.5 x 35.9 Rectangle");
    System.out.println(rect2.width);
    System.out.println(rect2.height);
    System.out.println(rect2.getArea());
    System.out.println(rect2.getPerimeter());
  }

}
