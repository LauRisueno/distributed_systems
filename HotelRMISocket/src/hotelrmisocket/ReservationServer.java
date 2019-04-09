package hotelrmisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class ReservationServer extends UnicastRemoteObject implements IReservationServer {

    private static final int CLIENT_BANK_SERVER_PORT = 5001;
    public static final int CENTRAL_BANK_SERVER_PORT = 5002;
    private static final int RESERVATION_SERVER_PORT = 5003;
    
    ReservationServer() throws java.rmi.RemoteException {
        super();
    }
    public static void main(String[] args) throws AlreadyBoundException, NotBoundException {
        try {
            //Socket Server 
            ReservationServer reservationServer;
            LocateRegistry.createRegistry(RESERVATION_SERVER_PORT);
            reservationServer = new ReservationServer();
            Naming.bind("ReservationServer", reservationServer);
            System.out.println("The Reservation Server is Ready!!!\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double quotation(Date initDate, Date finalDate, Date currentDate) throws RemoteException {
       int[] prices = {30,25,25,35,40};
       int aux = 0;
       int auxDayInitDate = initDate.getDay();
       int dayFinalDate = finalDate.getDay();
       double totalQuotation = 0.0;
       for(int i = 26;i<=30;i++){
           if( i == auxDayInitDate){
               aux = i;
               break;
           }
       }
       for(int i = aux;i<=30;i++){
           totalQuotation += prices[i];
           if(i == dayFinalDate){
               break;
           }
       }
        try {
            CentralBankServer centralBankServer;
            centralBankServer=(CentralBankServer)Naming.lookup("rmi://localhost/CentralBankServer");
            totalQuotation *= centralBankServer.dollarQuotation(currentDate);
        } catch (NotBoundException ex) {
            Logger.getLogger(ReservationServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) { 
            Logger.getLogger(ReservationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
       return totalQuotation;
    }

    @Override
    public void reservation(Date initDate, Date finalDate, int clientId, Date currentDate) throws RemoteException {
//        double totalCost = quotation(initDate,finalDate,currentDate);
//        Socket reservationServerClient = new Socket("localhost", CLIENT_BANK_SERVER_PORT);
//        BufferedReader fromServer = new BufferedReader(new InputStreamReader(reservationServerClient.getInputStream()));
//        toServer.println(cadena);  //mandar alservidor   
    }
    

}
