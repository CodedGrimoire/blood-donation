import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Donor2 extends User {
    private LocalDate donationDate;
    private long daysSinceLastDonation;
    private String location;
    public List<String> eligible;
    public boolean ch;
    String bloodType;

    // Constructor
    public Donor2(String name, LocalDate dob, String bloodType, LocalDate donationDate, String location) {
        super(name, dob);
        this.bloodType=bloodType;
        this.donationDate = donationDate;
        this.location = location;
        this.daysSinceLastDonation = calculateDaysSinceDonation();
        this.eligible = getEligibleBloodTypes();
        this.ch = canDonate(daysSinceLastDonation);
    }

    public void print() {
        System.out.println("Name: " + getName()); // Accessing name from the superclass User
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Donation Date: " + donationDate);
        System.out.println("Location: " + location);
        System.out.println("days Since last donation: " + daysSinceLastDonation);
        System.out.println("Can he donate?: " + ch);
        System.out.println("Blood Type he can donate to: " + eligible);
    }

    // Method to calculate the difference in days between the current date and the donation date
    private long calculateDaysSinceDonation() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.toEpochDay() - donationDate.toEpochDay();
    }

    // Method to determine compatible blood types based on the donor's blood type
    public List<String> getEligibleBloodTypes() {
        List<String> eligibleBloodTypes = new ArrayList<>();
        char bloodGroup = bloodType.charAt(0);
        char rhFactor = bloodType.charAt(1);

        // Determine compatible blood types based on the ABO blood group system
       
        switch (bloodGroup) {
            case 'A':
                if(rhFactor=='+' ||rhFactor=='-'){
                eligibleBloodTypes.add("A" + rhFactor);
                eligibleBloodTypes.add("AB" + rhFactor);
                }
                else{
                    rhFactor=bloodType.charAt(2);
                    eligibleBloodTypes.add("AB" + rhFactor);
                }
                break;
            case 'B':
                eligibleBloodTypes.add("B" + rhFactor);
                eligibleBloodTypes.add("AB" + rhFactor);
                break;
            case 'O':
                eligibleBloodTypes.add("A" + rhFactor);
                eligibleBloodTypes.add("B" + rhFactor);
                eligibleBloodTypes.add("AB" + rhFactor);
                eligibleBloodTypes.add("O" + rhFactor);
                break;
            
        }

        return eligibleBloodTypes;
    }


    // Method to determine if the donor can donate based on the days since the last donation
    public boolean canDonate(long daysSinceLastDonation)
    {
        if(daysSinceLastDonation>=120)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Getter method for daysSinceLastDonation
    public long getDaysSinceLastDonation() {
        return daysSinceLastDonation;
    }
}
