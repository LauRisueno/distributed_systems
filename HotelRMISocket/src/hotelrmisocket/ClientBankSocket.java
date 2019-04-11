package hotelrmisocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class ClientBankSocket {

    public static final int PORT = 5001;

    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket server = new ServerSocket(PORT); //instanciamos un servidor socket
            Socket client1;
            Socket client2;
            Socket client3;
            Socket clientServer;
            PrintStream toClient1;
            PrintStream toClient2;
            PrintStream toClient3;
            int clientAmount = 0;

            while (true) {
//              First Client
                client1 = server.accept();
                toClient1 = new PrintStream(client1.getOutputStream());
                toClient1.flush();
                toClient1.println("1");
                toClient1.flush();
                toClient1.println("300");

//              Second Client
                client2 = server.accept();
                toClient2 = new PrintStream(client2.getOutputStream());
                toClient2.flush();
                toClient2.println("2");
                toClient2.flush();
                toClient2.println("400");

//              Third Client
                client3 = server.accept();
                toClient3 = new PrintStream(client3.getOutputStream());
                toClient3.flush();
                toClient3.println("3");
                toClient3.flush();
                toClient3.println("1000");
                
                
                
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean reservationCheck(int clientId, double totalAmount) {
        boolean  isResevate = false;
        if ((clientId == 1 && totalAmount <= 300) || (clientId == 2 && totalAmount <= 400) || (clientId == 3 && totalAmount <= 1000)) {
//            System.out.println("Successful Reservation!!!");
            isResevate = true;
        } else {
//            System.out.println("Failed Reservation :(");
            isResevate = false;
        }
        return  isResevate;
    }

}
