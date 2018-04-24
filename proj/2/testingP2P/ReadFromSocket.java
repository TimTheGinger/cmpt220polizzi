package testingP2P;

import GUI.SocketGUI;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import simpleChatroom.SimpleChatroom;

public class ReadFromSocket implements Runnable {

  private SocketClient father;
  private Thread w;
  private Socket connectionToClient;
  private SocketGUI sockGui;

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
          consoleMessage(finRead);

          while(sockGui == null);

          sockGui.append(finRead);
        } catch (java.util.NoSuchElementException e) {
          consoleMessage("Error - unknown String");
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
  private void consoleMessage(String input) {
    System.out.println(input);
  }

  /**
   * Sets the GUI linked to this reader
   *
   * @param sockGui The GUI to be linked
   */
  public void setGui(SocketGUI sockGui) {
    this.sockGui = sockGui;
  }


  /**
   * Ends the run method, effectively deleting the reader
   */
  public void annihilate() {
    w.interrupt();
  }
}
