package hotelrmisocket;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public class CentralBankServer extends UnicastRemoteObject
        implements ICentralBank {

    public static final int CENTRAL_BANK_PORT = 1099;

    CentralBankServer() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String args[]) {
        try {
            CentralBankServer centralBankServer;
            LocateRegistry.createRegistry(CENTRAL_BANK_PORT);
            centralBankServer = new CentralBankServer();
            Naming.bind("CentralBankServer", centralBankServer);
            System.out.println("The Central Bank Server is Ready!!!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double dollarQuotation(Date date) throws RemoteException {
        double quotation = 0.0;
        if (date.equals("26-06-19")) {
            quotation = 6.90;
        }
        if (date.equals("27-06-19")) {
            quotation = 6.91;
        }
        if (date.equals("28-06-19")) {
            quotation = 6.93;
        }
        if (date.equals("29-06-19")) {
            quotation = 6.92;
        }
        if (date.equals("30-06-19")) {
            quotation = 6.96;
        }
        return quotation;
    }

}
