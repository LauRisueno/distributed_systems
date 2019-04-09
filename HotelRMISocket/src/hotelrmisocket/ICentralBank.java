package hotelrmisocket;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public interface ICentralBank  extends Remote{
    double dollarQuotation(String date) throws RemoteException;
}
