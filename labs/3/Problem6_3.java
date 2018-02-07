import java.util.*;

public class Problem6_3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter an integer to test if it is a palindrome: ");
    int input = scan.nextInt();

    System.out.println(isPalindrome(input));
  }

  // Return the reversal of an integer, e.g, reverse 456 returns 654
  public static int reverse(int number) {
    String num = Integer.toString(number);
    String reverse = "";

    for (int i = num.length() - 1; i >= 0; i--) {
      reverse += num.charAt(i);
    }

    return Integer.parseInt(reverse);
  }

  // Return true if number is a palindrome
  public static boolean isPalindrome(int number) {
    if (reverse(number) == number) {
      return true;
    }
    return false;
  }
}
