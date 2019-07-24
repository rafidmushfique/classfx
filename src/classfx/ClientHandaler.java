/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;

/**
 *
 * @author RafiD
 */
public class ClientHandaler extends Thread  implements Serializable
{
    Connection con=CreatingConnection.con;
  final  Socket socket;
  final  ObjectInputStream inputstream;
  final  ObjectOutputStream outputstream;

    public ClientHandaler(Socket s, ObjectInputStream dis, ObjectOutputStream dos)  
    { 
    
        socket = s; 
        inputstream = dis; 
        outputstream = dos; 
        
    }
    
    
}
