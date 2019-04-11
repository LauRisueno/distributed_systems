package hotelrmisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class ClientRMI {

    private static final int PORT = 5001;// puerto de comunicacion
    
    public static void main(String[] args) throws NotBoundException, ParseException {
        try {
            Socket client = new Socket("localhost", PORT); //conectarse al socket Debemos cambiar 
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            int id = Integer.parseInt(fromServer.readLine());  // devolver del servidor
            System.out.println("The client Identifier is: " + id);
            double totalAmount = Double.parseDouble(fromServer.readLine());
            System.out.println("The total Amount is: " + totalAmount);
            ReservationServer reservationServer;
            reservationServer = (ReservationServer) Naming.lookup("rmi://localhost/ReservationServer");
            SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate = sd.parse("26-06-19");
            Date initDate = sd.parse("26-06-19");
            Date finalDate =sd.parse("28-06-19");
            System.out.print("Cotización: "+reservationServer.quotation(initDate,finalDate,currentDate));
//            reservationServer.quotation("26-06-19", "28-06-19", "26-06-19");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
