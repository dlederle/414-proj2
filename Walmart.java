import java.io.*;
import java.util.*;
import dlederle.Customer;
import dlederle.Lane;

public class Walmart {
  private static ArrayList<Customer> customers;
  public static void main(String[] args) throws IOException {
    for(int i=1; i<=Integer.parseInt(args[1]); i++) {
      customers = new ArrayList<Customer>();
      readInput(args[0]);
      System.out.println("Running with " + i + " lanes.");
      process(i);
    }
  }
  
  private static void makeLanes(int count, ArrayList<Lane> lanes) {
    for(int i = 0; i < count; i++) {
      lanes.add(new Lane(i+1));
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
        customers.add(new Customer(tmp[1], tmp[0], tmp[2], tmp[3]));
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


  private static void printOut(ArrayList<Lane> lanes) {
    for(Lane l : lanes) { l.print(); }
  }

  private static void process(int count) {
      ArrayList<Lane> lanes = new ArrayList<Lane>();
      makeLanes(count, lanes);
      Lane least = lanes.get(0);
      for(Customer c : customers) {
        for(Lane l : lanes) {
          if(l.size() < least.size()) {
            least = l;
          }
        }
        least.add(c);
      }
      printOut(lanes);
  }
}
