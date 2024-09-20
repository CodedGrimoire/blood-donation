import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.application.Platform;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DonorSceneController implements Initializable {

    @FXML
    private DatePicker DonationDate;

    @FXML
    private Button OkButton;

    @FXML
    private ChoiceBox<String> TypeChoiceBox;

    @FXML
    private WebView webView;

    @FXML
    private TextField locationField;

    private final List<String> bloodTypes = Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

    private WebEngine webEngine;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TypeChoiceBox.getItems().addAll(bloodTypes);
       // locationField.setOnKeyPressed(this::handleLocationFieldKeyPress);
        webEngine = webView.getEngine();
        loadPage();
    }
    public void loadPage()
    {
        String mapUrl = "https://www.google.com/maps/@23.7810672,90.2548719,11z?entry=ttu";
            webEngine.load(mapUrl);
    }

    @FXML
    public void handleOkButton() {
        String bloodType = TypeChoiceBox.getValue();
        LocalDate donationDate = DonationDate.getValue();
        String location = locationField.getText();
        //ekhane name dob will be collected from the database
        Donor2 donor=new Donor2(name,dob,bloodType,donationDate,location);

        donor.print();
        Platform.exit();
    }

    @FXML
    public void handleLocationFieldKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            updateMap();
        }
    }

    private String updateMap() {
        String location = locationField.getText();

        try {
            String encodedLocation = URLEncoder.encode(location, "UTF-8");
            String mapUrl = "https://www.google.com/maps/place/" + encodedLocation;
            webEngine.load(mapUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return location;
        
    }
}
