import java.io.*;
import java.net.*;

public class Client {
    private String name;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private MessageListener messageListener;

    public Client(String name, Socket socket) throws IOException {
        this.name = name;
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String message) {
        out.println(name + ": " + message);
    }

    public void startListening() {
        new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    if (messageListener != null) {
                        messageListener.onMessageReceived(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void setMessageListener(MessageListener listener) {
        this.messageListener = listener;
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    public interface MessageListener {
        void onMessageReceived(String message);
    }
}
