import java.util.Scanner;

public class Problem4_13 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a letter: "); //prompt user input
    String scannedLetter = scan.next(); //scans user input

    char let = scannedLetter.toLowerCase().charAt(0); //convert scannedLetter into a char

    String vwl = "a consonant";

    //remove any possible invalid input (no input, input of more than one letter, input that is not a letter)
    if (scannedLetter.isEmpty() || scannedLetter.length() > 1 || let > 122 || let < 97) {
      vwl = "an Invalid Input";
    } else {
      if (isVowel(let)) {
        vwl = "a vowel";
      }
    }
    System.out.println(scannedLetter + " is " + vwl); //output
  }

  /**
   * Returns a boolean that tells if a character is a vowel
   *
   * @param let The letter to be tested, must be lowercase
   * @return True if the letter is a vowel, false otherwise
   */
  private static boolean isVowel(char let) {
    boolean vowel = false;

    //lowercase char values: 97, 101, 105, 111, 117, 121
    if (let == 97 || let == 101 || let == 105 || let == 111 || let == 117 || let == 121) {
      vowel = true;
    }

    return vowel;
  }

}
