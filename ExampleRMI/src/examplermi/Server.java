package examplermi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Laura Veronica Risueño Arancibia<lauri.lro4@gmail.com>
 */
public class Server extends UnicastRemoteObject implements IOperations {

    Server() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String args[]) throws RemoteException {
        try {
            Server server = new Server();
            LocateRegistry.createRegistry(1099);
            Naming.bind("Operations", server);
            System.out.println("The Server is Ready!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int maxNumber(int numberOne, int numberTwo, int numberThree) throws RemoteException {
        int max = 0;
        if (numberOne >= numberTwo && numberOne >= numberThree) {
            max = numberOne;
        } else if (numberTwo >= numberOne && numberTwo >= numberThree) {
            max = numberTwo;
        } else if (numberThree >= numberOne && numberThree >= numberTwo) {
            max = numberThree;
        }
        return max;
    }

}
