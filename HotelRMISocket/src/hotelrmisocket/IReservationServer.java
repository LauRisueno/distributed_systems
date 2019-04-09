/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelrmisocket;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public interface IReservationServer extends Remote{

    public double quotation(String initDate, String finalDate, String currentDate)throws RemoteException;
    public boolean reservation(String initDate, String finalDate, int clientId,String currentDate) throws RemoteException;
}
