package simpleChatroom;

import java.util.Scanner;

public class ServerStarter {

  public static void main(String[] args) {
    SimpleChat myServer = new SimpleChat(); //Creates a new chatroom

    Scanner scan = new Scanner(System.in); //Opens a scanner
    String close = scan.next();

    Boolean quit = false;

    //While quit is not inputted, the server stays up, then closes once quit is entered into the log
    while (!quit) {
      if (close.equals("quit")) {
        myServer.annihilate();
        quit = true;
      }
    }
    scan.close();
  }
}
