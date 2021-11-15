
package association;

//This will be for collecting donations and funding events.
public class Donations {
    private String donator;
    private double donationIndiv;
    private double donationTotal;
    private double donationGoal = 250000;
    private double maxDonation;
    private String maxDonor;
    
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
    
    public Donations(String donator) {
        this.donator = donator;
        this.donationIndiv = 0;
        this.donationTotal = 0;
        this.maxDonation = 0;
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
    public void setDonationIndiv(double donation, String user){
        this.donationIndiv = donation;
        this.donationTotal += donation;
        if(donation > maxDonation) {
            maxDonation = donation;
            maxDonor = user;
        }
        
    }
    /***
     * The method for returning and setting the total amount of donations given.
     * @return the total donations 
     */
    public double getDonationTotal(){
        return donationTotal;
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

    public double getMaxDonation() {
        return maxDonation;
    }

    public String getMaxDonor() {
        return maxDonor;
    }
    
    
    
}
