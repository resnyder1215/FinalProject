package association;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    String timeStr;
    
    public Time() {
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.timeStr = String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    
    public String toString(){
        this.timeStr = String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
        return timeStr;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    
    public static Time inputTime(Scanner input){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String time;
        Pattern p = Pattern.compile("([0-9]{1,2}):([0-9]{2})(:[0-9]{2})?");
        while(true){
            time = input.nextLine();
            Matcher m = p.matcher(time);
            if(!m.matches())
                System.out.println("ERROR! Invalid time format. Please type in military format (HH:MM:SS)");
            else{
                hours = Integer.parseInt(m.group(1));
                minutes = Integer.parseInt(m.group(2));
                if(m.groupCount() > 3)
                    seconds = Integer.parseInt(m.group(3));
                if(hours < 0 || hours > 24 || minutes < 0 || minutes > 60 || seconds < 0 || seconds > 60){
                    System.out.println("ERROR! Invalid time format. Please type a real time.");
                    continue;
                }
                
                return new Time(hours, minutes, seconds);
            }
        }
    }
}
