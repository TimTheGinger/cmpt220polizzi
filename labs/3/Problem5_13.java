public class Problem5_13 {

  public static void main(String[] args) {
    int n = 0;
    final int BRUTE_FORCE = 12000;

    while (Math.pow(n, 3) < BRUTE_FORCE) {
      n++;
    }

    System.out.println(n - 1);
    System.out.println(Math.pow(n - 1, 3));
  }
}
