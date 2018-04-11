package testingP2P;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import simpleChatroom.SimpleChatroom;

public class ReadFromSocket implements Runnable {

  private SocketClient father;
  private Thread w;
  private Socket connectionToClient;

  public ReadFromSocket(SocketClient parent, Socket clientConnection) {
    father = parent;
    connectionToClient = clientConnection;
    w = new Thread(this);
    w.start();
  }

  /**
   * Collects input from the ip
   */
  public void run() {
    try {
      Scanner in = new Scanner(connectionToClient.getInputStream());

      while (!Thread.interrupted()) {
        try {
          String finRead = in.nextLine();
          readMessage(finRead);
        } catch (java.util.NoSuchElementException e) {
          readMessage("Error - unknown String");
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Reads a message from a port
   *
   * @param input The message to be read
   */
  private void readMessage(String input) {
    System.out.println(input);
  }

  /**
   * Ends the run method, effectively deleting the reader
   */
  public void annihilate() {
    w.interrupt();
  }
}
