

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.lang.Math;


/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class TCPServer {
    
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
       
        while(true){
            
            System.out.println("En attente du client");
            //creating socket and waiting for client connection
            Socket socket = server.accept();


            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            long y = (long)ois.readObject();
            System.out.println("Y =" + y);

            
                
                //creating socket and waiting for client connection
                Socket socket2 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oii = new ObjectInputStream(socket2.getInputStream());
                //convert ObjectInputStream object to String
                int e = (int)oii.readObject();
                System.out.println("E= " + e);
                oii.close();
                socket2.close();
                

           





                

                //creating socket and waiting for client connection
                Socket socket3 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oiu = new ObjectInputStream(socket3.getInputStream());
                //convert ObjectInputStream object o String
                int y = (int) oiu.readObject();
                System.out.println("Y=" + y);
                oiu.close();
                socket3.close();
                
               
                long x =(((long)Math.pow(a,y))*((long)Math.pow(v,e)))%p;
                if ( e!=(message+x).hashCode() ){
                    System.out.println("Nope");
                }

                

            
        System.out.println("Fin");}
        //close the ServerSocket object
        
            }
      
    }
    
