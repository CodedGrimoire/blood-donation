import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    static List<Event2> events = new ArrayList<>();
}

class Event2 {
    String eventName;
    LocalDate dateOfEvent;
    String timeOfEvent;
    String location;

    Event2(String eventName, LocalDate eventDate, String timeOfEvent, String location) {
        this.eventName = eventName;
        this.dateOfEvent = eventDate;
        this.timeOfEvent = timeOfEvent;
        this.location = location;
    }

    public void addEvent(Event2 event) {
        Dashboard.events.add(event);
    }

    public void print() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + dateOfEvent);
        System.out.println("Event Location: " + location);
        System.out.println("Event Time: " + timeOfEvent);
    }

    @Override
    public String toString() {
        return "Event Name: " + eventName + ", Date: " + dateOfEvent + ", Time: " + timeOfEvent + ", Location: " + location;
    }
}
