/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author RafiD
 */
public class Server  implements Serializable  {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(5056);
        Socket socket;
        while ((socket = serversocket.accept()) != null) {
            try {
                //s = ss.accept(); 
                System.out.println("A new client is connected : " + socket);
                ObjectOutputStream ouputstream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputstream = new ObjectInputStream(socket.getInputStream());
                System.out.println("Assigning new thread for this client");
                Thread t = new  ClientHandaler(socket, inputstream, ouputstream);
                System.out.println("yeeehoooo");
                t.start();

            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
        serversocket.close();
    }
}
