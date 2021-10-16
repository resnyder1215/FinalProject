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
        Scanner input = new Scanner(System.in);
        //ArrayLists can store objects and don't have a set size!
        //This one is for the student OBJECTS
        ArrayList<Alumni> students = new ArrayList<>();
        //This one is for the event OBJECTS
        ArrayList<Training> classes = new ArrayList<>();
        //Alumni[] students = new Alumni[COUNT];
        //Training[] classes = new Training[COUNT];
        String User = "null";
        boolean logIn = false;
        int option;
        /** Run through the menu first, as loggedIn is FALSE
         * If User is null, it will ask you to register 
         * Otherwise you're presented with a full menu
         */
        do {
            if ("null".equals(User)) 
            {
                printMenuNew(); //Print the menu for a new user which asks them to register, but they can select other things
                System.out.println("Please select an option!");
                option = input.nextInt();
                //If option is (1), it pulls the newAlumni method so that they can register as an alumni
                if (option == 1) 
                {
                    User = newAlumni(studentListID, students);
                    System.out.println(User);
                    studentListID++;
                } 
                //Other others will go here, testing creating/viewing events currently
                else if (option == 4)
                {
                    menuEvent();
                    option = input.nextInt();
                    if (option == 1) 
                    {
                        newEvent(eventListID, classes);
                        eventListID++;
                    }    
                    else if (option == 4)
                    {
                        for(int i = 0; i < classes.size(); i++) 
                        System.out.println("[ " + (i + 1)  + " ]" + classes.get(i));
                    }
                    
                }
                //This would be our escape sequence
                else if (option == 5) 
                {
                    logIn = false;
                }
            } 
            else 
            {
                printMenuLogged(User);
                option = input.nextInt();
                if (option == 1) 
                {
                    System.out.println("No");
                } 
                else if (option == 2) 
                {

                }

             
            }
          }
        while (!logIn);
        
    }
    //method for printing a logged in user menu
    public static void printMenuLogged(String user) {
        System.out.println("Welcome, " + user + ". Please select an option.");
        System.out.println("*************************");
        System.out.println("1. Print Name Tag");
        System.out.println("2. Register an Event");
        System.out.println("3. Donate and Raffle");
        System.out.println("4. FAQ/contact us!");
        System.out.println("5. Events");
        System.out.println("6. Exit");
    }
    //method for printing a new user menu
    public static void printMenuNew() {
        System.out.println("Welcome, please register to continue!");
        System.out.println("*************************");
        System.out.println("1. Register");
        System.out.println("2. Donate");
        System.out.println("3. FAQ/contact us!");
        System.out.println("4. Events");
        System.out.println("5. Exit");
    }
    //method for printing event menu
    public static void menuEvent() {
        
        System.out.println("Select an option: ");
        System.out.println("1. Create a new event");
        System.out.println("2. Attend an event as a guest");
        System.out.println("3. Attend an event as a speaker");
        System.out.println("4. View events");
    }
    
    //method for creating a new event
    public static void newEvent(int eventListID, ArrayList classes) {
        int id = eventListID;
        Scanner input = new Scanner(System.in);
        Training event = new Training();
        System.out.println("This is the event creation menu.");
        System.out.println("Please fill out the following information: ");
        System.out.print("What is the training/event?");
        event.setCourse(input.next());
        System.out.println("Who will be presenting the event?");
        event.setPresenter(input.next());
        System.out.println("How many seats are available?");
        event.setSeats(input.nextInt());
        System.out.println("What date will this event take place?");
        event.setDate(input.next());
        System.out.println("What time will it start?");
        event.setTime(input.next());
        System.out.println("How long will it last?");
        event.setDuration(input.next());
        System.out.println("What room will the event take place in?");
        event.setRoom(input.next());
        classes.add(id, event);
    }

    //method for registering new alumni
    public static String newAlumni(int studentListID, ArrayList students) {
        String User;
        int id = studentListID;
        Scanner input = new Scanner(System.in);
        Alumni register = new Alumni();
        System.out.println("Welcome graduate! Please supply the following information: ");
        System.out.print("Name: ");
        register.setName(input.next());
        System.out.print("Address: ");
        register.setAddress(input.next());
        System.out.print("Major: ");
        register.setMajor(input.next());
        System.out.print("Graduation Year: ");
        register.setGrad(input.next());
        System.out.print("Occupation: ");
        register.setJob(input.next());
        System.out.print("Organization: ");
        register.setOrg(input.next());
        students.add(id, register);
        User = register.getName();
        return User;
    }
    
    

}