import java.util.Scanner;

public class Problem4_9 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a character: "); //prompt user input
    String charLet = scan.next(); //scan user input

    char letVal = charLet.charAt(0); //Get the char of the inputted letter

    //Cast the char to int to get the the Unicode value
    System.out.println("The Unicode for the character " + charLet + " is " + (int) letVal);
  }
}
