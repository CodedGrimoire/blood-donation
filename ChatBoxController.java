import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatBoxController {
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField inputField;
    @FXML
    private Button sendButton;

    private Client client;

    public void setClient(Client client) {
        this.client = client;
        client.setMessageListener(this::handleIncomingMessage);
        client.startListening();
    }

    @FXML
    public void initialize() {
        sendButton.setOnAction(event -> {
            String message = inputField.getText();
            if (!message.trim().isEmpty()) {
                client.sendMessage(message);
               // chatArea.appendText("Me: " + message + "\n");
                inputField.clear();
            }
        });
    }

    private void handleIncomingMessage(String message) {
        Platform.runLater(() -> chatArea.appendText(message + "\n"));
    }
}
