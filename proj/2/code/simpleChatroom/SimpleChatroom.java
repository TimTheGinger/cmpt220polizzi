package simpleChatroom;

import java.net.*;

public class SimpleChatroom implements Runnable {

  private Thread t;
  private Writer r;
  private Reader w;
  public Socket connectionToClient;
  public SimpleChat father;
  private String nick;

  public SimpleChatroom(SimpleChat parent, Socket clientConnection, String nickname) {
    father = parent;
    connectionToClient = clientConnection;
    r = new Writer(this, connectionToClient);
    w = new Reader(this, connectionToClient);
    t = new Thread(this);

    nick = nickname;
  }

  /**
   * Starts a thread
   */
  public void run() {
    try {

    }
//		catch (IOException e)
//		{
//			
//		}
    finally {

    }

  }

  /**
   * Gives parent the message to send to all users
   */
  public void sendAllMessage(String message, String nn) {
    father.sendAllMessage(message, nn);
  }

  /**
   * Gives parent information to send to all users
   *
   * @param info The information to be sent
   */
  public void sendAllInformation(String info) {
    father.sendAllInformation(info);
  }

  /**
   * Sends a private message directly to another user
   *
   * @param message The message to be sent
   * @param nickname The nickname of the user that the message is sent from
   * @param client The user the the message is sent to
   */
  public void sendMessage(String message, String nickname, SimpleChatroom client) {
    r.pvt();
    r.nick(nickname);
    r.queueMessage(message);
    r.sendUserMessage(client.getConnection());
  }

  /**
   * Sends a message to all users on the chatroom
   *
   * @param message The message to be sent to the users
   * @param nn The nickname of the user who sent the message
   */
  public void sendMessage(String message, String nn) {
    r.tell();
    r.nick(nn);
    r.queueMessage(message);
    r.tellMessage();
  }

  /**
   * Sends the user information from the server
   *
   * @param info The information from the server
   */
  public void sendInfo(String info) {
    r.queueMessage(info);
    r.tellMessage();
  }

  /**
   * gets the Reader of the user
   *
   * @return The Reader
   */
  public Reader getReader() {
    return w;
  }

  /**
   * Gets the Writer of the user
   *
   * @return The Writer
   */
  public Writer getWriter() {
    return r;
  }

  /**
   * Gets the current nickname of the user
   *
   * @return The current nickname
   */
  public String getNick() {
    return nick;
  }

  /**
   * Sets the nickname of a user to a new nickname, provided that the nickname is not previously
   * taken, and is a legal nickname. Then alerts all people on the server of the change as well as
   * logging it on the server.
   *
   * @param newNick The nickname to be changed to
   */
  public void setNick(String newNick) {
    if (father.getNickSet().contains(newNick)) {
      r.queueMessage("602 - Nickname Taken");
      r.sendUserMessage(connectionToClient);
    } else if (newNick.contains(" ")) {
      r.queueMessage("502 - Invalid Nickname");
      r.sendUserMessage(connectionToClient);
    } else {
      System.out.println(nick + " is now " + newNick);
      sendAllInformation("<" + nick + "> is now <" + newNick + ">");
      SimpleChatroom temp = father.clientList.remove(nick);
      father.clientList.put(newNick, temp);
      nick = newNick;
    }
  }

  /**
   * gets the socket that the user is on
   *
   * @return The socket the user is on
   */
  public Socket getConnection() {
    return connectionToClient;
  }

  /**
   * ends the thread, killing all processes
   */
  public void annihilate() {
    t.interrupt();
  }
}
