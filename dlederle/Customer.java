package dlederle;
import java.util.*;


public class Customer {

  private String firstName;
  private String lastName;
  private String enterTime;
  private int timeSpent;
  private int totalTimeSpent;

  public Customer(final String fName, final String lName, final String eTime, final String tSpent) {
    firstName = fName.trim();
    lastName = lName.trim();
    enterTime = eTime.trim();
    timeSpent = Integer.parseInt(tSpent.trim());
  }

  private String exitTime() {
    /*
    String[] tmp = enterTime.split(":");
    String hour = tmp[0].trim();
    int minutes = Integer.parseInt(tmp[1].trim()) + timeSpent;
    if(minutes > 60) {
      hour = Integer.toString(Integer.parseInt(hour) + 1);
      minutes -= 60;
    }
    return hour + ":" + String.format("%02d", minutes);
    */
  }

  public String toString() {
    return exitTime() + " - " + lastName + "," + firstName;
  }
}
