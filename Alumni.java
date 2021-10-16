/*
 * Use a combination of constructors and Array Lists to store and create entries?
 * Use switches to select menu options...
 * EX: "Select your option... "
 *  1. Register
 *  2. Donate
 *  3. Join class...
 * When a user registers it should log their name into a variable (EX: String currentUser = Alumni.getName();)
 * That should allow us to register the donations they make as well as what classes they're attending
 */
package association;

//Lets attempt without ArrayList first, then try and adapt an ArrayList later.

import java.util.Scanner;


public class Alumni {
    private String name;
    private String address;
    private String major;
    private String gradYear;
    private String occupation;
    private String organization;
    
    
    //default construct
    public Alumni() {
        
    }
    //overloaded construct with variables
    public Alumni(String name, String address, String major, String gradYear, String occupation, String organization) {
        this.name = name;
        this.address = address;
        this.major = major;
        this.gradYear = gradYear;
        this.occupation = occupation;
        this.organization = organization;
    } 
    
    /***
     * 
     * Getters and setters for alumni name 
     * @return their name
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /***
     * 
     * Getters and setters for alumni address 
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    /***
     * 
     *  Getters and setters for alumni major
     * @return the major 
     */

     public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    /***
     * 
     * Getters and setters for alumni graduation year
     * @return the graduation year
     */
     public String getGrad() {
        return gradYear;
    }
    
    public void setGrad(String gradYear) {
        this.gradYear = gradYear;
    }
    
    
    /***
     * 
     * Getters and setters for alumni jobs
     * @return the occupation
     */
   
    public String getJob() {
        return occupation;
    }
    
    public void setJob(String occupation) {
        this.occupation = occupation;
    }
    
    /***
     * 
     * Getters and setters for alumni organization
     * @return organization
     */
    
    public String getOrg() {
        return organization;
    }
    
    public void setOrg(String organization) {
        this.organization = organization;
    }
    
    
}
