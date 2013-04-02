package dlederle;
import java.util.*;


public class Customer {

  private String firstName;
  private String lastName;
  private String enterTime;
  private int timeSpentInLine;
  private int timeBeingServed;
  private int totalTimeSpent;

  public Customer(final String fName, final String lName, final String eTime, final String tSpent) {
    firstName = fName.trim();
    lastName = lName.trim();
    enterTime = eTime.trim();
    timeBeingServed = Integer.parseInt(tSpent.trim());
    totalTimeSpent = timeBeingServed;
  }

  public void timeInLine(int time) {
    timeSpentInLine = time;
    totalTimeSpent += timeSpentInLine;
  }
  
  public String enterTime() {
    return enterTime;
  }

  public int getTimeInLine() {
    return timeSpentInLine;
  }

  public int getTimeSpent() {
    return totalTimeSpent;
  }

  public String exitTime() {
    String[] tmp = enterTime.split(":");
    String hour = tmp[0].trim();
    int minutes = Integer.parseInt(tmp[1].trim()) + totalTimeSpent;
    if(minutes > 60) {
      hour = Integer.toString(Integer.parseInt(hour) + 1);
      minutes -= 60;
    }
    return hour + ":" + String.format("%02d", minutes);
  }

  public String toString() {
    return exitTime() + " - " + lastName + "," + firstName + ", waited " + timeSpentInLine + " minutes in line and " + totalTimeSpent + " minutes total.";
  }
}
