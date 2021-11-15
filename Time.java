package association;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author willi
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    String timeStr;
    
    /**
     * Default constructor
     */
    public Time() {
    }

    /**
     *
     * @param hours the hour that is entered for the time
     * @param minutes the minute that is entered for the time
     * @param seconds the second that is entered for the time
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.timeStr = String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

    /**
     *
     * @return the hour contained in the Time object
     */
    public int getHours() {
        return hours;
    }

    /**
     *
     * @return the minute contained in the Time object
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     *
     * @return the second contained in the Time object
     */
    public int getSeconds() {
        return seconds;
    }
    
    /**
     *
     * @return a formatted string that shows the time held by the object
     */
    public String toString(){
        this.timeStr = String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
        return timeStr;
    }

    /**
     *
     * @param hours the hour to set the Time object to
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     *
     * @param minutes the minute to set the Time object to
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     *
     * @param seconds the second to set the Time object to
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    
    /**
     *
     * @param input the Scanner object used to read the input
     * @return a new Time object
     */
    public static Time inputTime(Scanner input){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String time;
        //regex, looks for String in "HH:MM:SS" pattern
        Pattern p = Pattern.compile("([0-9]{1,2}):([0-9]{2})(:[0-9]{2})?");
        while(true){
            time = input.nextLine();
            Matcher m = p.matcher(time);
            if(!m.matches())
                System.out.println("ERROR! Invalid time format. Please type in military format (HH:MM:SS)");
            else{
                hours = Integer.parseInt(m.group(1));
                minutes = Integer.parseInt(m.group(2));
                //if seconds were provided (optional)
                if(m.groupCount() > 3)
                    seconds = Integer.parseInt(m.group(3));
                //validates that the time is valid
                if(hours < 0 || hours > 24 || minutes < 0 || minutes > 60 || seconds < 0 || seconds > 60){
                    System.out.println("ERROR! Invalid time format. Please type a real time.");
                    continue;
                }
                
                return new Time(hours, minutes, seconds);
            }
        }
    }
}
