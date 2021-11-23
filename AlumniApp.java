/*
 * This is the main class as well as menus and small methods.
 */
package association;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class AlumniApp {


    public static void main(String[] args) {
 
        int studentListID = 0;
        int eventListID = 0;
        Donations alumni = new Donations();
        Scanner input = new Scanner(System.in);
        ArrayList<Alumni> students = new ArrayList<>();
        ArrayList<Training> classes = new ArrayList<>();
        String User = "null";
 
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
                option = getOption(1, 3);
             
                switch (option) {

                    case 1:
                        User = newAlumni(studentListID, students);
                        studentListID++;
                        System.out.println(" ");
                        break;

                    case 2:
                        printFAQ();
                        System.out.println(" ");
                        break;

                    case 3:
                        logIn = false;
                    default:
                        break;
                }
            } else {
                printMenuLogged(User);
                option = getOption(1, 8);
                switch (option) {
                    case 1:
                        printNameTag(User);
                        System.out.println(" ");
                        break;
                    case 2:
                        newEvent(eventListID, classes);
                        eventListID++;
                        System.out.println(" ");
                        break;
                    case 3:
                        attendEventGuest(classes);
                        System.out.println(" ");
                        break;
                    case 4:
                        attendEventSpeaker(classes);
                        System.out.println(" ");
                        break;
                    case 5:
                        menuDonation(alumni);
                        option = getOption(1, 2);
                        switch (option) {
                            case 1:
                                makeDonation(alumni, User);
                                System.out.println(" ");
                                break;
                            case 2:
                                System.out.println(" ");
                                break;
                            default:
                                break;
                        }
                        break;
                    case 6:
                        printFAQ();
                        System.out.println(" ");
                        break;
                    case 7:
                        printReportMenu();
                        option = getOption(1, 3);
                        switch (option) {
                            case 1:
                                for (int i = 0; i < students.size(); i++) {
                                System.out.println("[ " + (i + 1) + " ]" + students.get(i));
                                }
                                System.out.println(" ");
                                break;
                            case 2:
                                if(classes.size() > 0){
                                for (int i = 0; i < classes.size(); i++) {
                                System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
                                }
                                System.out.println(" ");}
                                else
                                    System.out.println("No events to report.");
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.printf("Current donations goal: $%.2f\n", alumni.getDonationGoal());
                                System.out.printf("Current amount donated: $%.2f\n", alumni.getDonations());
                                System.out.println(" ");
                                break;
                            default:
                                break;
                                        }
                        break;
                    case 8:
                        User = "null";
                        break;
                    default:
                        break;

                }
            }
        } while (logIn);

    }

    

    /**
     * After a user is logged in they are presented with this menu
     * @param user the username of the person registered
     */
    public static void printMenuLogged(String user) {
        System.out.println("Welcome, " + user + ". Please select an option.");
        System.out.println("*************************");
        System.out.println("1. Print Name Tag");
        System.out.println("2. Create an Event");
        System.out.println("3. Attend an event as a guest");
        System.out.println("4. Register a speaker for an event");
        System.out.println("5. Donate");
        System.out.println("6. FAQ/contact us!");
        System.out.println("7. Reports");
        System.out.println("8. Log Out");
        System.out.println(" ");
    }


    /**
     * Before a user registers they are shown this menu
     */
    public static void printMenuNew() {
        System.out.println("Welcome, please register to continue!");
        System.out.println("*************************");
        System.out.println("1. Register");
        System.out.println("2. FAQ/contact us!");
        System.out.println("3. Exit");
        System.out.println(" ");
    }

    /**
     * This menu is for printing reports of Users, Events, and Donations
     */
    public static void printReportMenu() {
        System.out.println("Select a report to print: ");
        System.out.println("*************************");
        System.out.println("1. Users");
        System.out.println("2. Events");
        System.out.println("3. Donations");
        System.out.println("3. Exit");
        System.out.println(" ");
    }

    /**
     * This is a menu for making donations.
     * @param alumni imported alumni object for pulling donations
     */
    public static void menuDonation(Donations alumni) {
        System.out.println("This is our donations page!");
        System.out.println("*************************");
        System.out.printf("Current donations goal: $%.2f\n", alumni.getDonationGoal());
        System.out.printf("Current amount donated: $%.2f\n", alumni.getDonations());
        System.out.println("1. Make a donation");
        System.out.println("2. Exit");
        System.out.println(" ");
    }

    /**
     *
     * @param alumni imported alumni object for pulling donations
     * @param user the username of the person donating
     */
    public static void makeDonation(Donations alumni, String user) {
        double donation;
        System.out.println("What would you like to donate (or type \"exit\" to exit):?");
        donation = getDollarAmount(0.01);
        alumni.donate(user, donation);
        System.out.println("Current TOP Donators: ");
        System.out.printf("\t1. %-50s $%.2f\n\t2. %-50s $%.2f\n\t3. %-50s $%.2f\n", alumni.getMaxDonor(0) + ':', alumni.getMaxDonation(0), alumni.getMaxDonor(1) + ':', alumni.getMaxDonation(1), alumni.getMaxDonor(2) + ':', alumni.getMaxDonation(2));
        System.out.println(" ");
        System.out.printf("Current donations goal: $%.2f\n", alumni.getDonationGoal());
        System.out.printf("Current amount donated: $%.2f\n", alumni.getDonations());
        System.out.println(" ");
    }

    /**
     * Method for attending an event as a guest
     * @param classes import of the ArrayList for handling events and training
     */
    public static void attendEventGuest(ArrayList<Training> classes) {
        Training temp;
        int selection = 0;
        if (classes.size() > 0) {
            while (true) {
                System.out.println("*************************");
                System.out.println("Select event index (or \"exit\" to exit): ");
                for (int i = 0; i < classes.size(); i++) {
                    System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
                }
                selection = getOption();
                if (selection == -1) {
                    return;
                }
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
            System.out.println(" ");
        } else {
            System.out.println("No events to register for!");
        }
    }

    /**
     * Method for attending an event as a speaker
     * @param classes import of ArrayList for trainings and events
     */
    public static void attendEventSpeaker(ArrayList<Training> classes) {
        Training temp;
        int selection = 0;
        if (classes.size() > 0) {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("*************************");
                System.out.println("Select event index (or \"exit\" to exit):");
                for (int i = 0; i < classes.size(); i++) {
                    System.out.println("[ " + (i + 1) + " ]" + classes.get(i));
                }
                selection = getOption();
                if (selection == -1) {
                    return;
                }
                try {
                    temp = classes.get(selection - 1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid event index!");
                    continue;
                }
                break;
            }
            if (temp.getPresenterLength() < 3) {
                System.out.println("What is the name of the speaker?");
                temp.addPresenter(input.nextLine());
                System.out.println(temp.toString());
            } else {
                System.out.println("There are already 3 speakers at the event!");
            }
        } else {
            System.out.println("Sorry, no events to speak at!");
        }
        System.out.println(" ");
    }

    /**
     * Method for registering a new event
     * @param eventListID a running tally of each event registered in main
     * @param classes the ArrayList for handling training and events
     */
    public static void newEvent(int eventListID, ArrayList classes) {
        int id = eventListID;
        int seats = 0;
        Scanner input = new Scanner(System.in);
        Training event = new Training();
        System.out.println("This is the event creation menu.");
        System.out.println("Please fill out the following information: ");
        System.out.println(" ");
        System.out.println("What is the training/event?");
        event.setCourse(input.nextLine());
        System.out.println("Who will be presenting the event?");
        event.addPresenter(input.nextLine());
        System.out.println("How many seats are available?");
        seats = getOption();
        while (seats < 0) {
            System.out.println("You cannot have a negative number of seats!");
            seats = getOption();
        }
        event.setSeats(seats);
        System.out.println("What future date will this event take place? (MM/DD/YYYY)");
        event.setDate(Date.inputDate(input));
        System.out.println("What time will it start? (HH:MM:SS)");
        event.setTime(Time.inputTime(input));
        System.out.println("How long will it last? (HH:MM:SS)");
        event.setDuration(Time.inputTime(input));
        System.out.println("What room will the event take place in?");
        event.setRoom(input.nextLine());
        classes.add(id, event);
        System.out.println(" ");
    }

    /**
     * Method for registering as a new user
     * @param studentListID a running tally for each user that registers in main
     * @param students the ArrayList for handling new users and alumni
     * @return the username of the person registered
     */
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
        User = register.getFirstName() + " " + register.getLastName();
        System.out.println(" ");
        return User;
    }

    /**
     * Method for integer input validation
     * @return the option if it is valid
     */
    public static int getOption() {
        String optionStr;
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            optionStr = input.nextLine();
            if (optionStr.equals("x") || optionStr.equals("exit")) {
                return -1;
            }
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            return option;
        }
    }

   
    /**
     * method for testing if the user has entered an integer (with a maximum value)
     * @param max the maximum value they can enter
     * @return the option if valid
     */
    public static int getOption(int max) {
        String optionStr;
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            optionStr = input.nextLine();
            if (optionStr.equals("x") || optionStr.equals("exit")) {
                return -1;
            }
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            if (option <= max) {
                return option;
            } else {
                System.out.println("ERROR! The selected number is invalud! Please enter a value of at most " + max + ".");
            }
        }
    }

    /**
     * method for testing if the user has entered an integer (with a maximum and minimum value)
     * @param min the minimum integer user can enter
     * @param max the maximum integer user can enter
     * @return the option if valid
     */
    public static int getOption(int min, int max) {
        String optionStr;
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            optionStr = input.nextLine();
            if (optionStr.equals("x") || optionStr.equals("exit")) {
                return -1;
            }
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            if (option >= min && option <= max) {
                return option;
            } else {
                System.out.println("ERROR! The selected number is invalud! Please enter a value from " + min + " to " + max + ".");
            }
        }
    }

    /**
     * Method for setting minimum amount a user can donate
     * @param min the minimum amount one can donate (greater than 0, pretty much)
     * @return this is an exit command
     */
    public static double getDollarAmount(double min) {
        String optionStr;
        double option = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            optionStr = input.nextLine();
            if (optionStr.equals("x") || optionStr.equals("exit")) {
                break;
            }
            try {
                option = Double.parseDouble(optionStr);
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please enter a valid integer!");
                continue;
            }
            if (option >= min) {
                return option;
            } else {
                System.out.println("ERROR! The selected number is invalud! Please enter a value of at least " + min + ".");
            }
        }
        return -1;
    }

    /**
     * Prints a name tag for the user using their username and random title
     * @param User the username of registered user
     */
    public static void printNameTag(String User) {
        System.out.println("__________________________________");
        System.out.println("|                                 |");
        System.out.println("|      HELLO, MY NAME IS          |");
        System.out.println("          " + User + "              ");
        System.out.println("|                                 |");
        System.out.println("       " + getSuper() + "          ");
        System.out.println("|_________________________________|");
        System.out.println(" ");
    }

    /**
     * The roll table for generating a random superlative
     * @return a random superlative
     */
    public static String getSuper() {
        int option = 0;
        String superlative = "Nothing";
        Random rand = new Random();
        option = rand.nextInt(8);
        switch (option) {
            case 0:
                superlative = "Most Likely to Be A Crab";
                break;
            case 1:
                superlative = "Least Likely to Own A House";
                break;
            case 2:
                superlative = "Most Likely to Be Arrested";
                break;
            case 3:
                superlative = "Won't Try New Things";
                break;
            case 4:
                superlative = "Never Been More Alive";
                break;
            case 5:
                superlative = "Lost Their Diploma";
                break;
            case 6:
                superlative = "The Most Handsome";
                break;
            case 7:
                superlative = "Last Person Standing";
                break;
        }
        return superlative;
    }

    /**
     * Frequently asked questions for when the option is selected.
     */
    public static void printFAQ() {
        System.out.println(" Frequently Asked Questions");
        System.out.println("****************************");
        System.out.println("Q. Where does my money go?");
        System.out.println(" ");
        System.out.println("A. All alumni donations go towards facilitating alumni events.");
        System.out.println(" ");
        System.out.println("Q. Do I have to be an alumni to donate?");
        System.out.println(" ");
        System.out.println("A. No, but this is meant to be used primarily by alumni. Feel free to give!");
        System.out.println(" ");
        System.out.println("Q. What is your quest?");
        System.out.println(" ");
        System.out.println("A. I SEEK THE GRAIL.");
        System.out.println(" ");
    }
}
