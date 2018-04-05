package testingP2P;

import java.io.*;
import java.net.*;

public class SocketClient {

  Socket sock;
  int port = 8989;

  public static void main(String[] args) {
    new SocketClient();
  }

  public SocketClient() {
    openSocket();

    // write to socket
    new WriteToSocket(sock);

    // read from socket
    new ReadFromSocket(sock);
  }

  private void openSocket() {
    // open a socket and connect with a timeout limit
    try {
      InetAddress addr = InetAddress.getLocalHost();
      SocketAddress sockaddr = new InetSocketAddress(addr, port);
      sock = new Socket();

      // this method will block for the defined number of milliseconds
      int timeout = 2000;
      sock.connect(sockaddr, timeout);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (SocketTimeoutException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}