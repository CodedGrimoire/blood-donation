import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.List;

public class DashController {

    @FXML
    private ListView<String> list;

    @FXML
    private TextField nameField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField timeField;

    // Initialize the controller
    public void initialize() {
        updateListView(); // Update ListView when the scene loads
    }

    @FXML
    public void planEvent() {
        // Handle the event planning action here
        String eventName = nameField.getText();
        LocalDate eventDate = dateField.getValue();
        String eventLocation = locationField.getText();
        String eventTime = timeField.getText();
        Event2 event = new Event2(eventName, eventDate, eventTime, eventLocation);
        event.addEvent(event); // Add event to the list
        updateListView(); // Update ListView with new event
    }

    // Method to update the ListView with event details
    private void updateListView() {
        list.getItems().clear(); // Clear previous items
        for (Event2 event : Dashboard.events) {
            list.getItems().add(event.toString()); // Add event details to ListView
        }
    }
}
