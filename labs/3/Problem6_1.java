public class Problem6_1 {

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i+=10) {
      for(int j = 1; j <= 10; j++) {
        System.out.printf("%7d", getPentagonalNumber(i+j));
      }
      System.out.println();
    }
  }

  public static int getPentagonalNumber(int n) {
    return n * (3 * n - 1) / 2;
  }
}
