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
 * @author laurar
 */
public interface ICentralBank  extends Remote{
    double dollarquotation(String date) throws RemoteException;
}
