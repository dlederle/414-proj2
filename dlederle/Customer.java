package dlederle;
import java.util.*;


public class Customer {

  private String firstName;
  private String lastName;
  private String enterTime;
  private int timeSpentInLine;
  private int timeBeingServed;
  private int totalTimeSpent;
  private int line;

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
  
  public void setLine(int lineNum) {
    line = lineNum;
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
      int h = minutes / 60;
      hour = Integer.toString(Integer.parseInt(hour) + h);
      minutes -= (60 * h);
    }
    return hour + ":" + String.format("%02d", minutes);
  }

  public String toString() {
    return exitTime() + " - " + lastName + "," + firstName + ", waited " + timeSpentInLine + " minutes in line number " + line + " and " + totalTimeSpent + " minutes total.";
  }
}
