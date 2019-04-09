/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelrmisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class ReservationServer extends UnicastRemoteObject implements IReservationServer {

    private static final int CLIENT_BANK_SERVER_PORT = 5001;
    public static final int CENTRAL_BANK_SERVER_PORT = 5002;
    private static final int RESERVATION_SERVER_PORT = 5003;
//    public static void main(String args[]) { 
//	try {
//	    CentralBankServer centralBankServer;
//	    LocateRegistry.createRegistry(CENTRAL_BANK_SERVER_PORT);
//	    centralBankServer=new CentralBankServer(); 
//	    Naming.bind("Servidor", centralBankServer); 
//            System.out.println("The Central Bank Server is Ready\n");
//        }
//	catch (Exception e){
//	    e.printStackTrace();
//	}
//    }

    ReservationServer() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String[] args) throws AlreadyBoundException {
        try {
            //Socket Server 
            Socket reservationServerClient = new Socket("localhost", CLIENT_BANK_SERVER_PORT);
            //RMI Server

            //Reservation Server RMI
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
    public double quotation(String initDate, String finalDate, String currentDate) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reservation(String initDate, String finalDate, int clientId, String currentDate) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
