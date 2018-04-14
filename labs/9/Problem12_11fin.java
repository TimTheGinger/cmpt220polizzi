import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem12_11fin {

  public static void main(String[] args) throws IOException {
    //Check number of args
    if (args.length != 2) {
      System.out.println("Usage: java Problem12_11fin <word to remove> <filename>");
      System.exit(1);
    }

    //Open file and check that it exists
    File input = new File(args[1]);
    if (!input.exists()) {
      System.out.println("Input file does not exits.");
      System.exit(2);
    }

    File output = new File("tmp.txt");
    if (output.exists()) {
      output.delete();
    }

    Scanner in = new Scanner(input);
    PrintWriter out = new PrintWriter(output);

    while (in.hasNextLine()) {
      String line = in.nextLine();
      line = line.replaceAll(args[0], "");
      out.println(line);
    }
    in.close();
    input.delete();
    out.close();
    output.delete();
  }
}
