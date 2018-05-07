//package Problem13_7;

public class ColorableTester {

  public static void main(String[] args) {
    GeometricObject13_7[] geo = new GeometricObject13_7[5];

    for (int i = 0; i < 5; i++) {
      geo[i] = new Square(i + 1);
    }

    for (GeometricObject13_7 sq : geo) {
      System.out.print(sq.getArea() + " ");
      if (sq instanceof Colorable) {
        ((Colorable) sq).howToColor();
      }
      System.out.println();
    }

  }

}
