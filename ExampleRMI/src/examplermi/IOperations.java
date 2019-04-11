package examplermi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Laura Veronica Risueño Arancibia <lauri.lro4@gmail.com>
 */
public interface IOperations extends Remote {
    int maxNumber(int numberOne,int numberTwo, int numberThree) throws RemoteException;
}
