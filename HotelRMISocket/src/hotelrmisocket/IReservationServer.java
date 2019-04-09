package hotelrmisocket;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public interface IReservationServer extends Remote{
    public double quotation(Date initDate, Date finalDate, Date currentDate)throws RemoteException;
    public void reservation(Date initDate, Date finalDate, int clientId,Date currentDate) throws RemoteException;
}
