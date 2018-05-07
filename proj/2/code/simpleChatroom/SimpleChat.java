package simpleChatroom;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChat implements Runnable {

  private Thread t;
  private int incr;
  public Map<String, SimpleChatroom> clientList;
  private int portNum;

  public SimpleChat(int port) {
    clientList = new HashMap<>();
    portNum = port;
    t = new Thread(this);
    t.start();
  }

  /**
   * starts the thread the chatroom is on
   */
  public void run() {
    ServerSocket ss = null;

    //attempts to host a new server on a port, then waits for users to connect
    try {
      ss = new ServerSocket(portNum);
      ss.setSoTimeout(1000);
      System.out.println("Waiting for connections");

      while (!Thread.interrupted()) {
        try {
          //if a user connects, logs the user's connection,
          // sends the chatroom a message, and adds them to the list of users
          Socket s = ss.accept();
          String nick = "Guest" + incr;
          clientList.put(nick, new SimpleChatroom(this, s, nick));
          System.out.println("Client " + nick + " connected");
          incr++;

          sendAllInformation("Client " + nick + " connected");
        } catch (SocketTimeoutException e) {

        }
      }

// In the case of a runtime exception, the server disconnects all users,
// then kills itself and all threads under it
    } catch (IOException e) {
      System.out.println("IOException - Server terminating");
    } finally {
      System.out.println("Terminating server");
      try {
        closeAll();
        ss.close();
      } catch (IOException e) {

      } finally {
        System.out.println("Server terminated");
      }
    }
  }

  /**
   * Gets the list of all user's nicknames
   *
   * @return The list of all user's nicknames
   */
  public Set<String> getNickSet() {
    return clientList.keySet();
  }

  /**
   * Gets the current user count
   *
   * @return The number of users currently online
   */
  public int getIncr() {
    return incr;
  }

  /**
   * Sends a message to all users on the chatroom
   *
   * @param message The message to be sent to all users
   * @param nn The nickname of the user sending the message
   */
  public void sendAllMessage(String message, String nn) {
    Collection<SimpleChatroom> clients = clientList.values();
    for (SimpleChatroom sch : clients) {
      sch.sendMessage(message, nn);
    }
  }

  /**
   * Sends a server announcement to all users on the chatroom
   *
   * @param info The announcement/information
   */
  public void sendAllInformation(String info) {
    Collection<SimpleChatroom> clients = clientList.values();
    for (SimpleChatroom sch : clients) {
      sch.sendInfo(info);
    }
  }

  /**
   * Kills all user's connections
   */
  public void closeAll() {
    Collection<SimpleChatroom> clients = clientList.values();
    for (SimpleChatroom sch : clients) {
      sch.annihilate();
    }
    clients.clear();
  }

  /**
   * deletes a user
   *
   * @param name the user to be removed
   */
  public void killUser(String name) {
    clientList.get(name).annihilate();
    clientList.remove(name);
  }

  /**
   * terminates the thread, killing all processes
   */
  public void annihilate() {
    t.interrupt();
  }
}
