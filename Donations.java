
package association;

import java.util.ArrayList;

//This will be for collecting donations and funding events.
public class Donations {
    private String donator;
    private double donations;
    private double donationGoal = 250000;
    private ArrayList<String[]> maxDonations;
    //For indexing the String arrays in maxDonations
    private final int DONOR = 0;
    private final int DONATION = 1;
    
/***
 * Default constructor for Donations
 */
    public Donations(){
        this.maxDonations = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            this.maxDonations.add(new String[2]);
        }
        for(String[] arr : maxDonations){
            arr[DONOR] = "Empty";
            arr[DONATION] = "0";
        }
    }
    
    public Donations(String donator){
        this.donator = donator;
        this.donations = 0;
        this.maxDonations = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            this.maxDonations.add(new String[2]);
        }
        for(String[] arr : maxDonations){
            arr = new String[2];
            arr[DONOR] = "Empty";
            arr[DONATION] = "0";
        }
    }

    public String getDonator() {
        return donator;
    }

    public double getDonations() {
        return donations;
    }

    public double getDonationGoal() {
        return donationGoal;
    }
    
    public double getMaxDonation(int index) {
        return Double.parseDouble(maxDonations.get(index)[1]);
    }
    
    public String getMaxDonor(int index){
        return maxDonations.get(index)[DONOR];
    }
    
    public void setMaxDonation(int index, double amount){
        this.maxDonations.get(index)[DONATION] = String.format("%.2f", amount);
    }
    
    public void setMaxDonation(int index, String amount){
        this.maxDonations.get(index)[DONATION] = amount;
    }
    
    public void setMaxDonor(int index, String user){
        this.maxDonations.get(index)[DONOR] = user;
    }
    
    public void donate(String user, double amount){
        if(amount < 0.00)
            System.out.println("ERROR! Cannot donate a negative amount!");
        else if(amount == 0.00)
            System.out.println("ERROR! Cannot donate $0.00!");
        else{
            this.donations += amount;
            if(amount > getMaxDonation(0) && amount > getMaxDonation(1) && amount > getMaxDonation(2)){
                this.maxDonations.set(2, this.maxDonations.get(1).clone());
                this.maxDonations.set(1, this.maxDonations.get(0).clone());
                setMaxDonor(0, user);
                setMaxDonation(0, amount);
            }
            else if(amount > getMaxDonation(1) && amount > getMaxDonation(2)){
                this.maxDonations.set(2, this.maxDonations.get(1).clone());
                setMaxDonor(1, user);
                setMaxDonation(1, amount);
            }
            else if(amount > getMaxDonation(2)){
                setMaxDonor(2, user);
                setMaxDonation(2, amount);
            }
        }
    }
}
