package Problem12_11;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String toRemove = scan.next();
    String filename = scan.next();

    File sourceFile = new File(filename);

    remove(toRemove, sourceFile);
  }

  private static void remove(String toRemove, File filename) {
    try {
      Scanner input = new Scanner(filename);
      PrintWriter output = new PrintWriter(filename);

      while (input.hasNext()) {
        String oldLine = input.nextLine();
        String newLine = oldLine;

        while (newLine.contains(toRemove)) {
          int removeIndex = newLine.indexOf(toRemove);
          newLine = newLine.substring(0, removeIndex) +
              newLine.substring(removeIndex + toRemove.length());
        }
        output.println(newLine);
      }

      System.out.println("Process complete");
    } catch (java.io.FileNotFoundException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
