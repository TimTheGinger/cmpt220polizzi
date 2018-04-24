package simpleChatroom;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Reader implements Runnable {

  private Thread w;
  private Socket connectionToClient;
  private SimpleChatroom father;

  public Reader(SimpleChatroom parent, Socket clientConnection) {
    father = parent;
    connectionToClient = clientConnection;
    w = new Thread(this);
    w.start();
  }

  /**
   * Checks each line as sent for protocols and applies them as tasked
   */
  public void run() {
    try {
      Scanner in = new Scanner(connectionToClient.getInputStream());

      while (!Thread.interrupted()) {
        Scanner read = new Scanner(in.nextLine());
        String finRead = read.nextLine();

        checkForProtcals(finRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (java.util.NoSuchElementException e){
      e.printStackTrace();
    }
  }

  /**
   * Checks for specific protocols
   *
   * @param input The text sent to the chat
   */
  private void checkForProtcals(String input) {
    String protocalCheck = input;
    String after = "";
    String in;
    String protocal = input;

    //gets the first character and everything after the first space
    try {
      protocalCheck = input.substring(0, 1);
      after = input.substring(input.indexOf(" ") + 1);
    } catch (StringIndexOutOfBoundsException i) {

    }

    //if the first character is a '/' then there is a protocol
    if (protocalCheck.equals("/")) {
      try {
        //try block checks if there is a space after the protocol call and then gets the command
        if (input.indexOf(" ") < 0) {
          protocal = input.substring(1);
        } else {
          protocal = input.substring(1, input.indexOf(" "));
        }

        //sanitizes the call
        protocal = protocal.toLowerCase();
      } catch (StringIndexOutOfBoundsException i) {

      }

      switch (protocal) {
        /*
        "tell"

        Sends a message to everyone in the chatroom
        */
        case "tell":
          father.sendAllMessage(" " + after, father.getNick());
          break;

        /*
        "disconnect"

        Disconnects the user from the chatroom and publicly 'tells' everyone in the room who
        disconnected.
        */
        case "disc":
          try {
            father.annihilate();
            father.getReader().annihilate();
            father.getWriter().annihilate();
            father.sendAllInformation("<" + father.getNick() + "> has disconnected");
            father.connectionToClient.close();
            father.father.clientList.remove(father.getNick());
            System.out.println("<" + father.getNick() + "> disconnected");
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;

        /*
        "nickname"

        Sets the user's nickname to a new nickname
        */
        case "nick":
          father.setNick(after);
          break;

        /*
        "send"

        Sends a private message to one user in the chat. Requires the person's nickname.
         */
        case "send":
          try {
            in = after.substring(0, after.indexOf(" ")); //gets nickname

            if (!father.father.getNickSet().contains(in)) { //checks if nickname is valid
              father.sendInfo("600 - Nickname not found");
              break;
            }

            String msg = after.substring(after.indexOf(" "));
            father
                .sendMessage(" " + msg, father.getNick(), father.father.clientList.get(in));
          } catch (StringIndexOutOfBoundsException i) { //throws if the format of the message is wrong
            father.sendInfo("666 - Format is SEND <Nickname> <Message>");
          }
          break;

        /*
        "list"

        lists all users currently in the chatroom.
        */
        case "list":
          if (father.father.getNickSet().isEmpty()) {
            father.sendInfo("604 - Failure");
          }

          Set<String> list = father.father.getNickSet();
          father.sendInfo(list.toString());
          break;

        /*
        "help"

        Brings up a help menu that lists all of the commands and a general description on what they
        do.
        */
        case "help":
          father.sendInfo(
              "\n/tell - Send public message\n/disc - Disconnect from server\n"
                  + "/nick <name> - Sets nickname\n/send <user> - Send private message"
                  + "\n/list - Lists all online user's nicknames");
          break;

        /*
        default

        If no commands that are listed above are put after the '/', then the user will be prompted
        to type '/help' to bring up the list of commands.
        */
        default:
          father.sendInfo("Type /help for commands");
          break;
      }
      //if no command is directly inputted, the message will be 'told' to the whole chatroom
    } else {
      father.sendAllMessage(input, father.getNick());
    }
  }

  /**
   * Ends the run method, effectively deleting the reader
   */
  public void annihilate() {
    w.interrupt();
  }
}
