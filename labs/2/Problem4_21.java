import java.util.Scanner;

public class Problem4_21 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a SSN: "); //prompt user input
    String ssn = scan.next(); //scan user input

    String valid = "an invalid";

    boolean digit = true;

    //Check each digit to check if its a valid int
    for (int i = 0; i < ssn.length(); i++) {
      char temp = ssn.charAt(i);
      if (temp > 57 || temp < 48) {
        if (temp != 45) {
          digit = false;
        }
      }
    }

    //check if the ssn is the correct length, with the correct format
    if (ssn.length() == 11 && ssn.charAt(3) == 45 && ssn.charAt(6) == 45 && digit) {
      valid = "a valid";
    }

    System.out.println(ssn + " is " + valid + " social security number");
  }
}
//SSNs are in the format XXX-XX-XXXX, where X is a digit
//numbers char vals are 48 to 57