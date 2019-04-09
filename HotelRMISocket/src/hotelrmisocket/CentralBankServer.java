package hotelrmisocket;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author laurar
 */
public class CentralBankServer extends UnicastRemoteObject
    implements ICentralBank{

    public static final int CENTRAL_BANK_PORT = 5002;
    public static void main(String args[]) { 
	try {
	    CentralBankServer centralBankServer;
	    LocateRegistry.createRegistry(CENTRAL_BANK_PORT);
	    centralBankServer=new CentralBankServer(); 
	    Naming.bind("Servidor", centralBankServer); 
            System.out.println("The Central Bank Server is Ready!!!\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 
    
    CentralBankServer() throws java.rmi.RemoteException{
	super();
    }
    @Override
    public double dollarQuotation(String date) throws RemoteException {
         double quotation = 0.0;
        switch(date){
            case "26-06-19":
                quotation =  6.90;
                break;
            case "27-06-19":
                quotation = 6.91;
                break;
            case "28-06-19":
                quotation = 6.93;
                break;
            case "29-06-19":
                quotation = 6.92;
                break;
            case "30-06-19":
                quotation = 6.96;
                break;
            default:
                break;
        }
        return quotation;
    }
    
}
