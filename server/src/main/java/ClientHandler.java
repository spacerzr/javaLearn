import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private final Socket socket;
    private final BufferedReader in;
    private final BufferedWriter out;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {

        while (true) {
            try {
                String message = in.readLine();

                for (ClientHandler client : Server.clients) {
                    if (client != this) {
                        client.send(message);
                    }
                }
            } catch (Exception e) {
                System.out.println("Клиент отключился");
                Server.clients.remove(this);
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            }
        }
    }

    public void send(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
