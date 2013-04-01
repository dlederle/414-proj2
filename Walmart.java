import java.io.*;
import java.util.*;
import dlederle.Customer;
import dlederle.Lane;

public class Walmart {
  private static Lane lane;
  public static void main(String[] args) throws IOException {
    lane = new Lane();
    if(readInput(args[0])) { 
      printOut();
    }
  }

  private static boolean readInput(String filename) {
    //Adapted from http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    BufferedReader br = null;
    String[] tmp;
    try {
      String line;
      br = new BufferedReader(new FileReader(filename));
      while((line = br.readLine()) != null) {
        tmp = line.split(",");
        lane.add(new Customer(tmp[1], tmp[0], tmp[2], tmp[3]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(br != null) {
          br.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return true;
  }

  private static void printOut() {

  }
}
