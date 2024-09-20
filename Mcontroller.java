import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.lang.Exception;
//oi request blood button click korle eta open hobe
public class Mcontroller {

    @FXML
    private TextField LocField;

    @FXML
    private Button okButton;

    @FXML
    private ChoiceBox<String> type;

    @FXML
    void initialize() {
        // Initialize the ChoiceBox with blood types
        type.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
    }

    
    @FXML
void handleOk(ActionEvent event) {
    try {
        // Get the selected blood type and location
        String selectedBloodType = type.getValue();
        String locationText = LocField.getText();
        
        // Create a Match object with the provided values
        Match mt = new Match(selectedBloodType, locationText);
        mt.print();
         Button btn = (Button) event.getSource();
    Window window = btn.getScene().getWindow();
    window.hide();
        
        // Consume the event to prevent default behavior
        event.consume();
    } catch (Exception e) {
        // Handle the exception (e.g., display an error message)
        e.printStackTrace(); // Print the stack trace for debugging
    }
}

}
