package testingP2P;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadFromSocket implements Runnable {

  Socket sock;

  public ReadFromSocket(Socket sock) {
    this.sock = sock;

    Thread r = new Thread(this);
    r.start();
  }

  public void run() {
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      String str;
      while (!Thread.interrupted()) {
        str = rd.readLine();
        System.out.println(str);
      }
      rd.close();
    } catch (java.io.IOException e) {

    }
  }
}
