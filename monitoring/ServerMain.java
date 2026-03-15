import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            ExecutorService pool = Executors.newFixedThreadPool(10);

            System.out.println("Server started on port 5000");

            while(true){

                Socket client = serverSocket.accept();

                System.out.println("Client connected");

                pool.execute(new ClientHandler(client));
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}