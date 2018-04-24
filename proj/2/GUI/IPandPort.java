package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import testingP2P.SocketClient;

public class IPandPort {

  private JButton submitButton;
  private JTextField iPField;
  private JTextField portField;
  private JLabel portLabel;
  private JLabel iPLabel;
  private JPanel iPandPortPanel;
  private JLabel connectionFailed;

  private boolean connected;

  public static void main(String[] args){
    new IPandPort();
  }

  public IPandPort() {
    connected = false;

    //Sets up frame
    JFrame frame = new JFrame("IPandPort");
    frame.setSize(475, 275);

    //Sets up elements of form
    iPandPortPanel = new JPanel();

    iPLabel = new JLabel("IP", SwingConstants.CENTER);
    iPLabel.setPreferredSize(new Dimension(300, 50));

    iPField = new JTextField(SwingConstants.CENTER);
    iPField.setPreferredSize(new Dimension(400, 25));

    portLabel = new JLabel("Port", SwingConstants.CENTER);
    portLabel.setPreferredSize(new Dimension(300, 50));

    portField = new JTextField(SwingConstants.CENTER);
    portField.setPreferredSize(new Dimension(300, 25));

    submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String ip = iPField.getText();
        int port = Integer.parseInt(portField.getText());

        SocketClient sockConn = new SocketClient(ip, port);

        if (sockConn.isConnected()) {

          connected = true;

          System.out.println(connected);
          System.out.println(ip);
          System.out.println(port);

          iPField.setText("");
          portField.setText("");

          frame.setVisible(false);

          SocketGUI chatRoom = new SocketGUI(sockConn.getReader(), sockConn.getWriter());
        } else {
          connectionFailed.setText("INVALID IP OR PORT NUMBER");
        }
      }
    });

    connectionFailed = new JLabel("", SwingConstants.CENTER);
    connectionFailed.setPreferredSize(new Dimension(300, 50));

    //Adding things to the frame and making the frame visible
    iPandPortPanel.add(iPLabel, BorderLayout.CENTER);
    iPandPortPanel.add(iPField, BorderLayout.CENTER);
    iPandPortPanel.add(portLabel, BorderLayout.CENTER);
    iPandPortPanel.add(portField, BorderLayout.CENTER);
    iPandPortPanel.add(submitButton, BorderLayout.AFTER_LAST_LINE);
    iPandPortPanel.add(connectionFailed, BorderLayout.CENTER);

    frame.add(iPandPortPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public boolean isConnected(){
    return connected;
  }
}
