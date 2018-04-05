package testingP2P;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteToSocket implements Runnable {

  Scanner scan = new Scanner(System.in);
  Socket sock;

  public WriteToSocket(Socket sock) {
    this.sock = sock;
    Thread t = new Thread(this);
    t.start();
  }

  public void run() {
    try {
      BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

      while (!Thread.interrupted()) {
        String next = scan.next();
        wr.write(next);
        wr.flush();
      }
    } catch (java.io.IOException e) {

    }
  }


}
