/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelrmisocket;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author laurar
 */
public class Server extends UnicastRemoteObject
    implements ICentralBank{

    @Override
    public double dollarquotation(String date) throws RemoteException {
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
