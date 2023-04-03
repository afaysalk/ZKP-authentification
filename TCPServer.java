

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
        int g =3;
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
                long t = (long)oii.readObject();
                System.out.println("T= " +t);
                oii.close();
                socket2.close();
                

           

 //create ObjectOutputStream object
 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
 //write object to Socket
 Random rand = new Random();

 long c = rand.nextLong(200);             
 oos.writeObject(c);



                

                //creating socket and waiting for client connection
                Socket socket3 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oiu = new ObjectInputStream(socket3.getInputStream());
                //convert ObjectInputStream object o String
                long r = (long)oiu.readObject();
                System.out.println("R=" + r);
                oiu.close();
                socket3.close();
                
               
                long x =(((long)Math.pow(g,r))*((long)Math.pow(y,c)));
                if ( t!=x ){
                    System.out.println("Nope");
                }

                

            
        System.out.println("Fin");}
        //close the ServerSocket object
        
            }
      
    }
    
