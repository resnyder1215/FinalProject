
package association;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author willi
 */
public class Date {
    private int day;
    private int month;
    private int year;
    String dateStr;
    
    /**
     * Default Constructor
     */
    public Date(){
    }

    /**
     *
     * @param day the day that is entered for the date
     * @param month the month that is entered for the date
     * @param year the year that is entered for the date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        //Formats date into string
        this.dateStr = String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }

    /**
     *
     * @return the day contained in the Date object
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @return the month contained in the Date object
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @return the year contained in the Date object
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @return a formatted string that shows the date held by the object
     */
    public String toString() {
        //Formats date into string
        this.dateStr = String.format("%02d/%02d/%04d", this.month, this.day, this.year);
        return dateStr;
    }

    /**
     *
     * @param day the day to set the Date object to
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *
     * @param month the month to set the Date object to
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     *
     * @param year the year to set the Date object to
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     *
     * @param input the Scanner object used to read the input
     * @return a new Date object
     */
    public static Date inputDate(Scanner input){
        int month;
        int day;
        int year;
        String date;
        //regex, looks for String in "MM/DD/YYYY" pattern
        Pattern p = Pattern.compile("([0-9]{1,2})/([0-9]{1,2})/([0-9]{1,4})");
        while(true){
            date = input.nextLine();
            Matcher m = p.matcher(date);
            if(!m.matches())
                System.out.println("ERROR! Invalid date format! Please enter a date in the MM/DD/YYYY format.");
            else{
                month = Integer.parseInt(m.group(1));
                day = Integer.parseInt(m.group(2));
                year = Integer.parseInt(m.group(3));
                switch(month){
                    //months with 30 days
                    case 4: case 6: case 9: case 11:
                        if(day < 1 || day > 30){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    //months with 31 days
                    case 1: case 3: case 5: case 7:
                    case 8: case 10: case 12:
                        if(day < 1 || day > 31){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    //February
                    case 2:
                        //accounts for leap years
                        if(day < 1 || (year % 4 != 0 && day > 28) || (year % 4 == 0 && day > 29)){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                        continue;
                }
                //4-digit years only
                if(year < 1 || year > 9999){
                    System.out.println("ERRROR! Invalid date entered! Please enter a valid date.");
                    continue;
                }
                
                return new Date(day, month, year);
            }
        }
    }
}
