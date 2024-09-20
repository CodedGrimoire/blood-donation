import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrganizationController {

    @FXML
    private TextField nameField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ListView<String> bloodListView;

    @FXML
    private TextField bloodTypeField;

    @FXML
    private Button addBloodTypeButton;

    @FXML
    private Button removeBloodTypeButton;

    @FXML
    private Button okButton;

    private Organization organization;

    public void initialize() {
        choiceBox.getItems().addAll("Hospital", "Blood Donation", "Non-Profit");
    }

    @FXML
    public void handleAddBloodType() {
        String bloodType = bloodTypeField.getText();
        if (organization != null && bloodType != null && !bloodType.isEmpty()) {
            organization.addAvailableBloodType(bloodType);
            updateBloodListView();
            bloodTypeField.clear();
        }
    }

    @FXML
    public void handleRemoveBloodType() {
        String selectedBloodType = bloodListView.getSelectionModel().getSelectedItem();
        if (organization != null && selectedBloodType != null) {
            organization.removeAvailableBloodType(selectedBloodType);
            updateBloodListView();
        }
    }

    @FXML
    public void inputField() {
        String name = nameField.getText();
        String type = choiceBox.getValue();
        String loc = locationFieled.getValue();
        if (name != null && !name.isEmpty() && type != null) {
            organization = new Organization(name, type,loc);
            updateBloodListView();
            closeWindow();
        }
    }

    private void updateBloodListView() {
        bloodListView.getItems().clear();
        if (organization != null) {
            bloodListView.getItems().addAll(organization.getAvailableBlood());
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
