package simpleChatroom;

import java.util.Scanner;

public class ServerStarter {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); //Opens a scanner

    System.out.print("enter the port number (4 digits): ");
    int port = scan.nextInt();
    SimpleChat myServer = new SimpleChat(port); //Creates a new chatroom


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
