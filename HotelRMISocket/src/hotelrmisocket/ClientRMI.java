package hotelrmisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class ClientRMI {

    private static final int PORT = 5001;// puerto de comunicacion

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", PORT); //conectarse al socket Debemos cambiar 
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            int id = Integer.parseInt(fromServer.readLine());  // devolver del servidor
            System.out.println("The client Identifier is: " + id);
            double totalAmount = Double.parseDouble(fromServer.readLine());
            System.out.println("The total Amount is: " + totalAmount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
