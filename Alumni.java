/*
* This is the alumni class for handling registration and information for registered alumnus
*/
package association;

import java.util.Scanner;

public class Alumni {
    private String firstName;
    private String lastName;
    private String address;
    private String major;
    private String gradYear;
    private String occupation;
    private String organization;
    
    /**
     * @class Alumni is the constructor for each student registered
     */
    public Alumni() {
        
    }

    /**
     *
     * @param firstName The first name of registered user
     * @param lastName The last name of registered user
     * @param address The address of registered user
     * @param major The major of registered user
     * @param gradYear The graduation year of registered user
     * @param occupation The occupation of registered user
     * @param organization The organization a registered user belongs to
     */
    public Alumni(String firstName, String lastName, String address, String major, String gradYear, String occupation, String organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.major = major;
        this.gradYear = gradYear;
        this.occupation = occupation;
        this.organization = organization;
    } 
    
    /***
     * 
     * Getter for alumni first name 
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for alumni first name
     * @param firstName First name of user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Getter for alumni last name
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for alumni last name
     * @param lastName the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /***
     * 
     * Getter for alumni address 
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Setter for alumni address
     * @param address mailing address for alumni
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /***
     * 
     * Getter for alumni major
     * @return the major 
     */

     public String getMajor() {
        return major;
    }
    
    /**
     * Setter for alumni major
     * @param major the area of study the alumni graduated in
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /***
     * 
     * Getter for alumni graduation year
     * @return the graduation year
     */
     public String getGrad() {
        return gradYear;
    }
    
    /**
     * Setter for alumni graduation year
     * @param gradYear the year the alumni graduated school
     */
    public void setGrad(String gradYear) {
        this.gradYear = gradYear;
    }
    
    
    /***
     * 
     * Getter for alumni occupation
     * @return the occupation
     */
   
    public String getJob() {
        return occupation;
    }
    
    /**
     * Setter for alumni occupation
     * @param occupation the alumni current job
     */
    public void setJob(String occupation) {
        this.occupation = occupation;
    }
    
    /***
     * 
     * Getter for organization alumni belongs to
     * @return organization
     */
    
    public String getOrg() {
        return organization;
    }
    
    /**
     * Setter for the organization alumni belongs to
     * @param organization the current business or company alumni works for
     */
    public void setOrg(String organization) {
        this.organization = organization;
    }
    
    /**
     * toString method for printing alumni information
     * @return a formatting for printing the alumni information from an ArrayList
     */
    public String toString() {
       String ret = "User name: " + this.getFirstName() + " " + this.getLastName() + " |";               
       ret += " |" + " Major: "      + this.getMajor() + " |" +
                " Graduation Year: " + this.getGrad() + " |" +
                " Major: "           + this.getMajor() + " |" +
                " Organization: "        + this.getOrg();
       return ret;
   }
    
    
}
