package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledDocument;
import testingP2P.ReadFromSocket;
import testingP2P.WriteToSocket;

public class SocketGUI implements Runnable {

  private JButton button1;
  private JTextField textField1;
  private JTextArea textArea1;
  private JFrame frame;

  public SocketGUI(ReadFromSocket extReader, WriteToSocket extWriter) {
    ReadFromSocket reader = extReader;
    reader.setGui(this);
    Thread t = new Thread();

    //Sets up frame
    frame = new JFrame();
    frame.setSize(600, 400);

    //TextArea BS

    JPanel middlePanel = new JPanel();
    middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));

    //Sets up TextArea
    textArea1 = new JTextArea(16, 58);
    textArea1.setEditable(false);
    JScrollPane scroll = new JScrollPane(textArea1);
    textArea1.setText("Welcome to PortConnect");
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    middlePanel.add(scroll);

    //Sets up the background jPanel
    JPanel inputPanel = new JPanel(new BorderLayout());

    //All the message bar's text bs
    textField1 = new JTextField("Write Message Here");
    textField1.requestFocusInWindow();

    //The bs with dealing with placeholder text
    textField1.setForeground(Color.GRAY);
    textField1.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (textField1.getText().equals("Write Message Here")) {
          textField1.setText("");
          textField1.setForeground(Color.BLACK);
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (textField1.getText().isEmpty()) {
          textField1.setForeground(Color.GRAY);
          textField1.setText("Write Message Here");
        }
      }
    });

    //Send button
    button1 = new JButton("Send");

    // Sends any text in TextField1 to the server
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        extWriter.queueMessage(textField1.getText());
        textField1.setText("");
      }
    });

    //Layout
    inputPanel.add(textField1, BorderLayout.CENTER);
    inputPanel.add(button1, BorderLayout.EAST);

    //Adding things to the jFrame and then making it visible
    frame.add(middlePanel, BorderLayout.CENTER);
    frame.add(inputPanel, BorderLayout.SOUTH);

    frame.pack();
    frame.getRootPane().setDefaultButton(button1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    t.start();
  }

  /**
   * Allows this frame to be set to visible or hidden from another class
   *
   * @param visible True if the frame is visible, false otherwise
   */
  public void setVisibility(boolean visible) {
    frame.setVisible(visible);
  }

  /**
   * Appends toAppend to textArea1
   *
   * @param toAppend the String to be appended to textArea1
   */
  public void append(String toAppend) {
    textArea1.append("\n" + toAppend);
  }

  @Override
  public void run() {

  }
}
