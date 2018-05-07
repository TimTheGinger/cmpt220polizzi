package simpleChatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Writer implements Runnable {

  private Socket connectionToClient;
  private Thread r;
  private SimpleChatroom father;
  private Queue<String> queue;

  /**
   * Constructs a new Writer to send messages to the chatroom
   *
   * @param parent The parent user that controls the Writer
   * @param clientConnection The socket that the client is connected with
   */
  public Writer(SimpleChatroom parent, Socket clientConnection) {
    connectionToClient = clientConnection;
    father = parent;
    queue = new LinkedList<String>();
    r = new Thread(this);
    r.start();
  }

  /**
   * Creates a thread
   */
  public void run() {
    while (!Thread.interrupted()) {

    }
  }

  /**
   * Adds a nickname to the queue to be sent
   *
   * @param nn The nickname to be added to the queue
   */
  public void nick(String nn) {
    queue.add("<" + nn + ">" + " » ");
  }

  /**
   * Adds a message to the queue to be sent
   *
   * @param message The message to be added to the queue
   */
  public void queueMessage(String message) {
    queue.add(message);
  }

  /**
   * Adds a TLL tag to the queue
   */
  public void tell() {
    queue.add("TLL ");
  }

  /**
   * adds a MSG tag to the queue
   */
  public void pvt() {
    queue.offer("MSG ");
  }

  /**
   * Empties the queue and returns a single String of the items contained within
   *
   * @return toFlush, the String containing all of the materials that where within the queue before
   * it is dumped
   */
  private String emptyQueue() {
    String toFlush = "";

    while (!queue.isEmpty()) {
      toFlush += queue.poll();
    }

    return toFlush;
  }

  /**
   * Tells a message to the whole chatroom
   */
  public void tellMessage() {
    try {
      PrintWriter out = new PrintWriter(connectionToClient.getOutputStream());
      out.println(emptyQueue());
      out.flush();
    } catch (IOException e) {
      System.out.println("666 - FAILURE");
    }
  }

  /**
   * Sends a message to a specific user
   *
   * @param client The socket of the user the message is to be sent to
   */
  public void sendUserMessage(Socket client) {
    try {
      PrintWriter out = new PrintWriter(client.getOutputStream());
      out.println(emptyQueue());
      out.flush();
    } catch (IOException e) {
      System.out.println("FAILURE");
    }
  }

  /**
   * Ends the thread, killing the functions of this Writer
   */
  public void annihilate() {
    r.interrupt();
  }
}
