import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                ClientHandler handler = new ClientHandler(socket);
                clients.add(handler);
                handler.start();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
