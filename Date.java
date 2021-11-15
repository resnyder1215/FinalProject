
package association;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Date {
    private int day;
    private int month;
    private int year;
    String dateStr;
    
    public Date(){
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dateStr = String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        this.dateStr = String.format("%02d/%02d/%04d", this.month, this.day, this.year);
        return dateStr;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public static Date inputDate(Scanner input){
        int month;
        int day;
        int year;
        String date;
        Pattern p = Pattern.compile("([0-9]{1,2})/([0-9]{2})/([0-9]{1,4})");
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
                    case 4: case 6: case 9: case 11:
                        if(day < 1 || day > 30){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    case 1: case 3: case 5: case 7:
                    case 8: case 10: case 12:
                        if(day < 1 || day > 31){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    case 2:
                        if(day < 1 || (year % 4 != 0 && day > 28) || (year % 4 == 0 && day > 29)){
                            System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("ERROR! Invalid date entered! Please enter a valid date.");
                        continue;
                }
                if(year < 1 || year > 9999){
                    System.out.println("ERRROR! Invalid date entered! Please enter a valid date.");
                    continue;
                }
               
                return new Date(day, month, year);
            }
        }
    }
}
