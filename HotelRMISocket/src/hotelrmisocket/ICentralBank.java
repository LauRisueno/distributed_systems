package hotelrmisocket;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public interface ICentralBank  extends Remote{
    double dollarQuotation(Date date) throws RemoteException;
}
