
package association;

//The training should include course name, presenter name, available of seats, date, time, duration, and room
    public class Training {
    private String course;
    private String presenter;
    private int seats;
    private String date;
    private String time;
    private String duration;
    private String room;
    
    
    public Training(){
        
    }
    
    public Training(String course, String presenter, int seats, String date, String time, String duration, String room){
        this.course = course;
        this.presenter = presenter;
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
    public String getPresenter() {
        return presenter;
    }
    
    public void setPresenter(String presenter) {
        this.presenter = presenter;
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
        return ("Event name: " + this.getCourse()+ " |" +
                " Presenter: "  + this.getPresenter() + " |" +
                " Seats: "      + this.getSeats() + " |" +
                " Date: "       + this.getDate() + " |" +
                " Time: "       + this.getTime() + " |" +
                " Duration: "   + this.getDuration()  + " |" +
                " Room: "       + this.getRoom());
        
   }
}
