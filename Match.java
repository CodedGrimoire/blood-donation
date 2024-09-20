public class Match {
    private String BloodType;
    private String Location;
    //ekhane ei bloodtype ar location ,atch korbi databse er donor theke.match korle donor er kache alert jabe

    public Match(String BloodType, String Location) {
        this.BloodType = BloodType;
        this.Location = Location;
    }

    public void print() {
        System.out.println("Selected Blood Type: " + BloodType);
        System.out.println("Location: " + Location);
    }
}
