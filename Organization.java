import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private String type;
    private List<String> availableBlood;
    private String location;

    public Organization(String name, String type,String location) {
        this.name = name;
        this.type = type;
        this.availableBlood = new ArrayList<>();
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setLocation()
    {
        this.location=location;
    }
    public String getLocation() {
        return location;
    }


    public List<String> getAvailableBlood() {
        return new ArrayList<>(availableBlood);
    }

    public void addAvailableBloodType(String bloodType) {
        if (!availableBlood.contains(bloodType)) {
            availableBlood.add(bloodType);
        }
    }

    public void removeAvailableBloodType(String bloodType) {
        availableBlood.remove(bloodType);
    }
}
