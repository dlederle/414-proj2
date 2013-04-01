package dlederle;
import java.util.*;
import dlederle.Customer;

public class Lane {

  private Customer currCust;
  private ArrayList<Customer> custLine;
  

  public Lane() {
    currCust = null;
    custLine = new ArrayList<Customer>();
    
  }

  public void add(Customer c) {

  }

  public boolean empty() {
    return currCust == null;
  }

}
