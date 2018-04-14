package testingP2P;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WriteToSocket implements Runnable {

  private SocketClient father;
  private Scanner scan;
  private Socket connectionToClient;
  private Thread r;
  private Queue<String> queue;

  /**
   * Constructs a new Writer to send messages to the chatroom
   *
   * @param clientConnection The socket that the client is connected with
   */
  public WriteToSocket(SocketClient parent, Socket clientConnection) {
    father = parent;
    scan = new Scanner(System.in);
    connectionToClient = clientConnection;
    queue = new LinkedList();
    r = new Thread(this);
    r.start();
  }

  /**
   * Creates a thread
   */
  public void run() {
    while (!Thread.interrupted()) {
      if (scan.hasNext()) {
        String nextLine = scan.nextLine();
        queueMessage(nextLine);
        sendUserMessage(connectionToClient);

        if (nextLine.equals("/disc")) {
          father.kill();
        }
      }
    }
  }

  /**
   * Adds a message to the queue to be sent
   *
   * @param message The message to be added to the queue
   */
  public void queueMessage(String message) {
    queue.offer(message);
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
      System.out.println("Message Send Failure to port " + connectionToClient);
    }
  }

  /**
   * Ends the thread, killing the functions of this Writer
   */
  public void annihilate() {
    r.interrupt();
  }
}
