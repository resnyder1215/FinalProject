/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package association;

//This will be for collecting donations and funding events.
public class Donations {
    private String donator;
    private double donationIndiv;
    private double donationTotal;
    private double donationGoal;
    
/***
 * Default constructor for Donations
 */
    public Donations(){
        
    }
    
/***
 * Overloaded constructor for Donations
 * @param donator the person making the donation
 * @param donationIndiv the amount donated by an individual
 * @param donationTotal the amount total donated by all parties
 * @param donationGoal the goal to meet in donations
 */    
    
    public Donations(String donator, double donationIndiv, double donationTotal, double donationGoal) {
        this.donator = donator;
        this.donationIndiv = donationIndiv;
        this.donationTotal = donationTotal;
        this.donationGoal = donationGoal;
    }
    
   /***
     * Getters and setters for a donator
     * @return the name of a donator
     */
    
    public String getDonator(){
        return donator;
    }
    public void setDonator(String donator){
        this.donator = donator;
        
    }
    
    
    /***
     * Getters and setters for individual donations
     * @return the individual donation
     */
    
    public double getDonationIndiv(){
        return donationIndiv;
    }
    public void setDonationIndiv(double donation){
        this.donationIndiv = donation;
        
    }
    /***
     * The method for returning and setting the total amount of donations given.
     * @return the total donations 
     */
    public double getDonationTotal(){
        return donationTotal;
    }
    public void setDonationTotal(double donation){
        this.donationTotal = donation;
        
    }
    /***
     * Set the donation goal and
     * @return the donation goal for an event  
     */
    public double getDonationGoal(){
        return donationGoal;
    }
    public void setDonationGoal(double donation){
        this.donationGoal = donation;
        
    }
    
}
