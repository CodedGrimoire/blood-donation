import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class ChatBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatBox.fxml"));
        Scene scene = new Scene(loader.load());

        ChatBoxController controller = loader.getController();
        
        String name = "User" + (int)(Math.random() * 1000);  // ekhane ami random user generate korsi ekhane tui database theke ene naam dibi

        Socket socket = new Socket("localhost", 12345);
        Client client = new Client(name, socket);
        controller.setClient(client);

        primaryStage.setTitle("Chat Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // Perform any necessary cleanup here, such as closing client connections
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*First e Server run dibi normlly.eta ekbar donor er jonno run korbi ekbar receiver er jonno erpor connect hoye jabe.mane ekta class banay data gula pass kore dibi */
