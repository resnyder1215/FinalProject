/*
* Class for handling events and training
*/

package association;

import java.util.ArrayList;

    public class Training {
    private String course;
    private ArrayList<String> presenter;
    private int seats;
    private Date date;
    private Time time;
    private Time duration;
    private String room;
    
    /**
     *
     */
    public Training(){
        this.presenter = new ArrayList<>();
    }
    
    /**
     *
     * @param course The event name or purpose
     * @param presenter The original speaker of the event
     * @param seats The amount of seats available
     * @param date The date of the event
     * @param time What time the event occurs
     * @param duration How long the event lasts
     * @param room What room this event takes place in
     */
    public Training(String course, String presenter, int seats, Date date, Time time, Time duration, String room){
        this.course = course;
        this.presenter = new ArrayList<>();
        this.presenter.add(presenter);
        this.seats = seats;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.room = room;
    }

        /***
     * 
     * Getter for event name 
     * @return the event name
     */
    public String getCourse() {
        return course;
    }

    /**
     * Setting the event name
     * @param course the name of the event or course
     */
    public void setCourse(String course) {
        this.course = course;
    }
    /***
     * 
     * Getter for event presenter 
     * @param index the ArrayList position for the speaker
     * @return the presenter name
     */
    public String getPresenter(int index) {
        return presenter.get(index);
    }
    
    /**
     * Setter for the event presenter
     * @param presenter one person presenting the event
     */
    public void addPresenter(String presenter) {
        this.presenter.add(presenter);
    }
    
    /**
     *
     * @return how many presenters there are currently
     */
    public int getPresenterLength(){
        return this.presenter.size();
    }
    
    /***
     * 
     *  Getter for number of seats available
     * @return the seats
     */

     public int getSeats() {
        return seats;
    }
    
    /**
     * Setter for number of seats available
     * @param seats number of seats available per event
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
    

    /**
     * This is the method to reserve a seat when registering for an event.
     */
    public void reserveSeat(){
        if(seats > 0)
            seats--;
        else
            System.out.println("No seats available!");
    }
    
    /***
     * 
     * Getter for event date
     * @return the event or course date
     */
     public Date getDate() {
        return date;
    }
    
    /**
     * Setter for event date
     * @param date the date the event occurs on in (MM/DD/YYYY) format
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    /***
     * 
     * Getter for time of training in (HH:MM:SS) format
     * @return the training time
     */
   
    public Time getTime() {
        return time;
    }
    
    /**
     * Setter for time of event
     * @param time the time of the event in (HH:MM:SS) format
     */
    public void setTime(Time time) {
        this.time = time;
    }
    
    /***
     * 
     * Getter for event duration
     * @return duration
     */
    
    public Time getDuration() {
        return duration;
    }
    
    /**
     * Setter for event duration
     * @param duration how long the event will last
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }
    
    /***
     * 
     * Getter for event room
     * @return room 
     */
    
    public String getRoom(){
        return room;
    
}

    /**
     * Setter for event room
     * @param room the room the event takes place in
     */
    public void setRoom(String room) {
        this.room = room;
    }
    
    /**
     * Method for printing event objects
     * @return a toString format for printing a list of event objects
     */
    @Override
   public String toString() {
       String str = "Event name: " + this.getCourse()+ " |" +
                " Presenters: ";
       for(int i = 0; i < presenter.size(); i++){
           str += presenter.get(i);
           if(i != presenter.size() - 1)
               str += ", ";
       }
       
       str += " |" + " Seats: "      + this.getSeats() + " |" +
                " Date: "       + this.getDate().toString() + " |" +
                " Time: "       + this.getTime().toString() + " |" +
                " Duration: "   + this.getDuration().toString()  + " |" +
                " Room: "       + this.getRoom();
       
       return str;
   }
}
