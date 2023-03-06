

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
        long g=3;
        long p=7;
        long y=6;
        while(true){
            
            System.out.println("En attente du client");
            //creating socket and waiting for client connection
            Socket socket = server.accept();


            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            long u = (long)ois.readObject();
            System.out.println("U =" + u);

            
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            Random rand = new Random();

            int e = rand.nextInt(2);             
            oos.writeObject(e);
            
            if(e==0){
                
                //creating socket and waiting for client connection
                Socket socket2 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oii = new ObjectInputStream(socket2.getInputStream());
                //convert ObjectInputStream object to String
                long v = (long)oii.readObject();
                System.out.println("V= " + v);
                oii.close();
                socket2.close();
                if(u!=(long)Math.pow(g,v)%p){
                    System.out.println("Mot de passe incorrect");
                    server.close();
                }
                }

            if(e==1){

                //creating socket and waiting for client connection
                Socket socket3 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oiu = new ObjectInputStream(socket3.getInputStream());
                //convert ObjectInputStream object to String
                long v = (long) oiu.readObject();
                System.out.println("V=" + v);
                oiu.close();
                socket3.close();
                if(((u*y)%p)!=(long)Math.pow(g,v)%p){
                    System.out.println("Mot de passe incorrect");
                    server.close();
                }
                }
                ois.close();
                oos.close();
                socket.close();

                
            //close resources
            //terminate the server if client sends exit request
            
            
        System.out.println("Fin");}
        //close the ServerSocket object
        
            }
      
    }
    
