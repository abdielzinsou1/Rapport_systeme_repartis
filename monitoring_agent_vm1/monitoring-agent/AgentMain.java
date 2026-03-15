import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class AgentMain {

    public static void main(String[] args) {

        while(true){

            try{

                Random r = new Random();

                int cpu = r.nextInt(100);
                int memory = r.nextInt(100);

                String json = "{\"node\":\"vm2\",\"cpu\":"+cpu+",\"memory\":"+memory+"}";

                Socket socket = new Socket("10.197.25.41",5000);

                PrintWriter writer =
                    new PrintWriter(socket.getOutputStream(),true);

                writer.println(json);

                socket.close();

                Thread.sleep(10000);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
