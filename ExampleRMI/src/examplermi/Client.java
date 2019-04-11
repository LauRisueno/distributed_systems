/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplermi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Laura Veronica Risueño Arancibia<lauri.lro4@gmail.com>
 */
public class Client {
    public static void main(String args[]) throws RemoteException{
        IOperations server;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            server = (IOperations)Naming.lookup("rmi://localhost/Operations");
            System.out.println("Enter three numbers");
            int numberOne = Integer.parseInt(input.readLine());
            int numberTwo = Integer.parseInt(input.readLine());
            int numberThree = Integer.parseInt(input.readLine());
            System.out.println("The Max Number is: " + server.maxNumber(numberOne, numberTwo, numberThree));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
