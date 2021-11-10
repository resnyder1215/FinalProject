
package association;

import java.util.ArrayList;

//The training should include course name, presenter name, available of seats, date, time, duration, and room
    public class Training {
    private String course;
    private ArrayList<String> presenter;
    private int seats;
    private String date;
    private String time;
    private String duration;
    private String room;
    
    
    public Training(){
        this.presenter = new ArrayList<>();
    }
    
    public Training(String course, String presenter, int seats, String date, String time, String duration, String room){
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
     * Getters and setters for course name 
     * @return the course name
     */
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    /***
     * 
     * Getters and setters for training presenter 
     * @return the presenter name
     */
    public String getPresenter(int index) {
        return presenter.get(index);
    }
    
    public void addPresenter(String presenter) {
        this.presenter.add(presenter);
    }
    
    public int getPresenterLength(){
        return this.presenter.size();
    }
    
    /***
     * 
     *  Getters and setters for number of seats
     * @return the seats
     */

     public int getSeats() {
        return seats;
    }
    
    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    //method to reserve a seat
    public void reserveSeat(){
        if(seats > 0)
            seats--;
        else
            System.out.println("No seats available!");
    }
    
    /***
     * 
     * Getters and setters for training date
     * @return the training date
     */
     public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    
    /***
     * 
     * Getters and setters for training time
     * @return the training time
     */
   
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    /***
     * 
     * Getters and setters for training duration
     * @return duration
     */
    
    public String getDuration() {
        return duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    /***
     * 
     * Getters and setters for training room
     * @return room
     */
    
    public String getRoom(){
        return room;
    
}
    public void setRoom(String room) {
        this.room = room;
    }
    
        
    
   @Override
   public String toString() {
       String ret = "Event name: " + this.getCourse()+ " |" +
                " Presenters: ";
       for(int i = 0; i < presenter.size(); i++){
           ret += presenter.get(i);
           if(i != presenter.size() - 1)
               ret += ", ";
       }
       
       ret += " |" + " Seats: "      + this.getSeats() + " |" +
                " Date: "       + this.getDate() + " |" +
                " Time: "       + this.getTime() + " |" +
                " Duration: "   + this.getDuration()  + " |" +
                " Room: "       + this.getRoom();
       
       return ret;
   }
}
