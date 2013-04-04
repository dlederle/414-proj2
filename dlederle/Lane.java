package dlederle;
import java.util.*;
import dlederle.Customer;

public class Lane {

  private ArrayList<Customer> custLine;

  public Lane() {
    custLine = new ArrayList<Customer>();
  }

  public void add(Customer c) {
    custLine.add(c);
    process(c);
  }

  public boolean empty() {
    return custLine.isEmpty();
  }

  public int timeLeft() {
    if(!empty()) {
      Customer last = custLine.get(custLine.size() - 1);
      return last.getTimeInLine();
    } else {
      return 0;
    }
  }

  public void print() {
    double timeInLine = 0;
    double timeTotal = 0;
    for(Customer c : custLine) { 
      System.out.println(c); 
      timeInLine += c.getTimeInLine();
      timeTotal += c.getTimeSpent();
    }
    System.out.println("Avg time in line for this lane was " + timeInLine / custLine.size());
    System.out.println("Avg total time for this lane was " + timeTotal / custLine.size());
  }

  private void process(Customer c) {
    /*
    System.out.println(c);
    System.out.println(custLine.size());
    */
    int wait;
    if(custLine.size() == 1) {
      wait = 0;
    } else {
      Customer first = custLine.get(custLine.indexOf(c) - 1);

      //Eww
      int fHr = Integer.parseInt(first.exitTime().split(":")[0].trim());
      int fMin = Integer.parseInt(first.exitTime().split(":")[1].trim());
      int cHr = Integer.parseInt(c.enterTime().split(":")[0].trim());
      int cMin = Integer.parseInt(c.enterTime().split(":")[1].trim());

      //Case where cust in front has been processed
      if(fHr < cHr || (fHr == cHr && fMin < cMin)) {
        wait = 0;
      } else if(fHr > cHr) {
        wait = 60 * (cHr - fHr) + (fMin - cMin);
      } else {
        wait = fMin - cMin;
      }
    }
    c.timeInLine(wait);
  }
}
