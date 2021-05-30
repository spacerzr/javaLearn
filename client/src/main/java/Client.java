import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 8080);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String inputMessage = in.readLine();
                        System.out.println("Пришло сообщение: " + inputMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        while (true) {
            System.out.println("Введите ваше сообщение: ");

            String myMessage = reader.readLine();
            out.write(myMessage + "\n");
            out.flush();
        }

    }
}
