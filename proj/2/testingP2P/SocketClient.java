package testingP2P;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient {

  private Socket sock;
  private static int port;
  private static String ip;
  private WriteToSocket writer;
  private ReadFromSocket reader;
  private boolean isConnected;


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    //Gimme my IP Address
    try {
      System.out.println(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    System.out.println("Enter a ip and a port");
    ip = scan.next();
    port = scan.nextInt();
    SocketClient c = new SocketClient();
  }

  public SocketClient() {
    isConnected = false;
    openSocket();

    // write to socket
    writer = new WriteToSocket(this, sock);

    // read from socket
    reader = new ReadFromSocket(this, sock);
  }

  public SocketClient(String ip, int port) {
    isConnected = false;
    this.ip = ip;
    this.port = port;

    openSocket();

    // write to socket
    writer = new WriteToSocket(this, sock);

    // read from socket
    reader = new ReadFromSocket(this, sock);
  }

  private void openSocket() {
    // open a socket and connect with a timeout limit
    try {
      InetAddress addr = InetAddress.getByName(ip);
      SocketAddress sockaddr = new InetSocketAddress(addr, port);
      sock = new Socket();

      // this method will block for the defined number of milliseconds
      int timeout = 2000;
      sock.connect(sockaddr, timeout);
      isConnected = true;
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (SocketTimeoutException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isConnected() {
    return isConnected;
  }

  public WriteToSocket getWriter() {
    return writer;
  }

  public ReadFromSocket getReader() {
    return reader;
  }

  public void kill() {
    writer.annihilate();
    reader.annihilate();
  }
}