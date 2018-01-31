import java.util.Scanner;

public class Problem3_17 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int rand = (int) (Math.random() * 3); //generates a random integer between 0 and 2

    System.out.print("(0) Rock, (1) Paper, (2) Scissors: "); //prompt user input
    int ui = scan.nextInt();

    System.out.println(
        "You threw a " + numToEnglish(ui) + ", and the computer threw a " + numToEnglish(rand));
    System.out.println(winnerCheck(rand, ui)); //Final print statement
  }

  /**
   * A method that changes a number into either rock, paper, or scissors
   *
   * @param num The number that will be changed into a String
   * @return The string of the value specified by num
   */
  private static String numToEnglish(int num) {
    String english;

    switch (num) {
      case 0:
        english = "Rock";
        break;
      case 1:
        english = "Paper";
        break;
      case 2:
        english = "Scissors";
        break;
      default:
        english = "FAILURE"; //for debugging purposes
        break;
    }

    return english;
  }

  /**
   * A method that will check who won the game of rps
   *
   * @param comp The randomly generated number
   * @param player The user generated number
   * @return A statement of the outcome of the rps game
   */
  private static String winnerCheck(int comp, int player) {
    int winner = 0;

    if (comp == 0) { //comp throws rock
      if (player == 1) { //player throws paper
        winner = 1; //player win
      }
      if (player == 2) { //player throws scissors
        winner = 2; //comp win
      }
    }

    if (comp == 1) { //comp throws paper
      if (player == 2) { //player throws scissors
        winner = 1; //player win
      }
      if (player == 0) { //player throws rock
        winner = 2; //comp win
      }
    }

    if (comp == 2) { //comp throws scissors
      if (player == 0) { //player throws rock
        winner = 1; //player win
      }
      if (player == 1) { //player throws paper
        winner = 2; //comp win
      }
    }

    String winStatement;

    if (winner == 1) { //player win
      winStatement = "You win!";
    } else if (winner == 2) { //comp win
      winStatement = "Computer wins!";
    } else {
      winStatement = "Tie!";
    }

    return winStatement;
  }
}
