/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package association;

import java.util.Scanner;
import java.util.ArrayList;
public class AlumniApp {

    public static void main(String[] args) {
        //used to set the index for students
        int studentListID = 0;
        //used to set the index for events
        int eventListID = 0;
        Donations alumni = new Donations();
        Scanner input = new Scanner(System.in);
        //ArrayLists can store objects and don't have a set size!
        //This one is for the student OBJECTS
        ArrayList<Alumni> students = new ArrayList<>();
        //This one is for the event OBJECTS
        ArrayList<Training> classes = new ArrayList<>();
        //Alumni[] students = new Alumni[COUNT];
        //Training[] classes = new Training[COUNT];
        //Username 
        String User = "null";
        //Session
        boolean logIn = true;
        int option = 0;
        /**
         * Run through the menu first, as loggedIn is FALSE If User is null, it
         * will ask you to register Otherwise you're presented with a full menu
         */
        do {
            if ("null".equals(User)) {
                printMenuNew(); //Print the menu for a new user which asks them to register, but they can select other things
                System.out.println("Please select an option!");
                option = getInt(1, 4);
                //If option is (1), it pulls the newAlumni method so that they can register as an alumni
                switch (option) {
                    /*else if (option == 2){
                }*/
                    //Other others will go here, testing creating/viewing events currently
                    case 1:
                        User = newAlumni(studentListID, students);
                        System.out.println(User);
                        studentListID++;
                        break;
                    //This would be our escape sequence
                    case 4:
                        logIn = false;
                    default:
                        break;
                }
            } else {
                printMenuLogged(User);
                option = getInt(1, 8);
                switch (option) {
                    case 1:
                        System.out.println("No");
                        break;
                    case 2:
                        newEvent(eventListID, classes);
                        eventListID++;
                        break;
                    case 3:
                        attendEventGuest(classes);
                        break;
                    case 4:
                        attendEventSpeaker(classes);
                        break;
                    case 5:
                        menuDonation(alumni);
                        option = getInt(1, 2);
                        switch (option) {
                            case 1:
                                makeDonation(alumni, User);
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("FAQs! PHONE NUMBERS/EMAILS");
                        break;
                    case 7:
                        for (int i = 0; i < classes.size(); i++) {
                            System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
                        }
                        break;
                }
            }
        } while (logIn);

    }

    //method for printing a logged in user menu
    public static void printMenuLogged(String user) {
        System.out.println("Welcome, " + user + ". Please select an option.");
        System.out.println("*************************");
        System.out.println("1. Print Name Tag");
        System.out.println("2. Register an Event");
        System.out.println("3. Attend an event as a guest");
        System.out.println("4. Attend an event as a speaker");
        System.out.println("5. Donate and Raffle");
        System.out.println("6. FAQ/contact us!");
        System.out.println("7. Events");
        System.out.println("8. Exit");
    }

    //method for printing a new user menu
    public static void printMenuNew() {
        System.out.println("Welcome, please register to continue!");
        System.out.println("*************************");
        System.out.println("1. Register");
        System.out.println("2. Login?");
        System.out.println("3. FAQ/contact us!");
        System.out.println("4. Exit");
    }

    //method for printing event menu
    public static void menuEvent() {

        System.out.println("Select an option: ");
        System.out.println("1. Create a new event");
    }
    
    //method for printing donation menu
    public static void menuDonation(Donations alumni) {
        System.out.println("This is our donations page!");
        System.out.println("*************************");
        System.out.printf("Current donations goal: $%.2f\n", alumni.getDonationGoal());
        System.out.printf("Current amount donated: $%.2f\n", alumni.getDonations());
        System.out.println("1. Make a donation");
        System.out.println("2. Exit");
    }
    
    //method for making donation
    public static void makeDonation(Donations alumni, String user) {
        double donation;
        System.out.println("What would you like to donate?");
        donation = getDollarAmount(0.01);
        alumni.donate(user, donation);
        System.out.println("Current TOP Donators: ");
        System.out.printf("\t1. %-50s %.2f\n\t2. %-50s %.2f\n\t3. %-50s %.2f\n", alumni.getMaxDonor(0) + ':', alumni.getMaxDonation(0), alumni.getMaxDonor(1) + ':', alumni.getMaxDonation(1), alumni.getMaxDonor(2) + ':', alumni.getMaxDonation(2));
    }
    
    //method for attending event as a guest
    public static void attendEventGuest(ArrayList<Training> classes) {
        Training temp;
        int selection = 0;
        while (true) {
            System.out.println("*************************");
            System.out.println("Select event index: ");
            for (int i = 0; i < classes.size(); i++) {
                System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
            }
            selection = getInt();
            try {
                temp = classes.get(selection - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid event index!");
                continue;
            }
            break;
        }
        temp.reserveSeat();
        System.out.println("Remaining seats for " + temp.getCourse() + ": " + temp.getSeats());
    }

    public static void attendEventSpeaker(ArrayList<Training> classes){
        Training temp;
        int selection = 0;
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("*************************");
            System.out.println("Select event index: ");
            for (int i = 0; i < classes.size(); i++) {
                System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
            }
            selection = getInt();
            try {
                temp = classes.get(selection - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid event index!");
                continue;
            }
            break;
        }
        if(temp.getPresenterLength() < 3){
            System.out.println("What is the name of the speaker?");
            temp.addPresenter(input.nextLine());
            System.out.println(temp.toString());
        }
        else{
            System.out.println("There are already 3 speakers at the event!");
        }
    }
    
    //method for creating a new event
    public static void newEvent(int eventListID, ArrayList classes) {
        int id = eventListID;
        Scanner input = new Scanner(System.in);
        Training event = new Training();
        System.out.println("This is the event creation menu.");
        System.out.println("Please fill out the following information: ");
        System.out.println("What is the training/event?");
        event.setCourse(input.nextLine());
        System.out.println("Who will be presenting the event?");
        event.addPresenter(input.nextLine());
        System.out.println("How many seats are available?");
        event.setSeats(getInt());
        System.out.println("What date will this event take place?");
        event.setDate(Date.inputDate(input));
        System.out.println("What time will it start? (HH:MM:SS)");
        event.setTime(Time.inputTime(input));
        System.out.println("How long will it last? (HH:MM:SS)");
        event.setDuration(Time.inputTime(input));
        System.out.println("What room will the event take place in?");
        event.setRoom(input.nextLine());
        classes.add(id, event);
    }

    //method for registering new alumni
    public static String newAlumni(int studentListID, ArrayList students) {
        String User;//the user name to be returned
        int id = studentListID;
        Scanner input = new Scanner(System.in);
        Alumni register = new Alumni();
        System.out.println("Welcome graduate! Please supply the following information: ");
        System.out.print("First name: ");
        register.setFirstName(input.nextLine());
        System.out.print("Last name: ");
        register.setLastName(input.nextLine());
        System.out.print("Address: ");
        register.setAddress(input.nextLine());
        System.out.print("Major: ");
        register.setMajor(input.nextLine());
        System.out.print("Graduation Year: ");
        register.setGrad(input.nextLine());
        System.out.print("Occupation: ");
        register.setJob(input.nextLine());
        System.out.print("Organization: ");
        register.setOrg(input.nextLine());
        students.add(id, register);
        User = register.getFirstName();
        return User;
    }
    
    //method for testing if the user has entered an integer (with no maximum value)
    public static int getInt() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                option = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            return option;
        }
    }

    //method for testing if the user has entered an integer (with a maximum value)
    public static int getInt(int max) {
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                option = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            if (option <= max) {
                return option;
            } else {
                System.out.println("ERROR! The selected number is invalid! Please enter a value up to " + max + ".");
            }
        }
    }

    //method for testing if the user has entered an integer (with a maximum and minimum value)
    public static int getInt(int min, int max) {
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                option = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            if (option >= min && option <= max) {
                return option;
            } else {
                System.out.println("ERROR! The selected number is invalid! Please enter a value between " + min + " and " + max + ".");
            }
        }
    }
    
    public static double getDollarAmount(double min){
        double option = 0;
        Scanner input = new Scanner(System.in);
        while(true){
            try{
                option = Double.parseDouble(String.format("%.2f", Double.parseDouble(input.nextLine())));
            } catch(NumberFormatException e){
                System.out.println("ERROR! Please enter a valid decimal number.");
                continue;
            }
            if(option >= min)
                return option;
            else
                System.out.println("ERROR! The selected number is invalid! Please enter a value of at least " + String.format("%.2f", min));
        }
    }
}
