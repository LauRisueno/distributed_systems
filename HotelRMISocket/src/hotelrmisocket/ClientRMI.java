/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelrmisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author laurar
 */
public class ClientRMI {

    private static final int PORT = 5001;// puerto de comunicacion

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", PORT); //conectarse al socket Debemos cambiar 
//            InputStreamReader isr = new InputStreamReader(System.in);
//            BufferedReader br = new BufferedReader(isr);
//            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String id = fromServer.readLine();  // devolver del servidor
            System.out.println("The client Identifier is: " + id);
            String totalAmount = fromServer.readLine();
            System.out.println("The total Amount is: " + totalAmount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
