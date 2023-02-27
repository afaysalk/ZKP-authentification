

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();


            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            long message = (long)ois.readObject();
            System.out.println("f(r) =" + message);

            
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            int e = 1;
            oos.writeObject(e);

            if(e==1){

            //creating socket and waiting for client connection
            Socket socket2 = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream oii = new ObjectInputStream(socket2.getInputStream());
            //convert ObjectInputStream object to String
            String message2 = (String) oii.readObject();
            System.out.println("Message Received: " + message2);
            if(message2.equalsIgnoreCase("exit")) ;
            }

            if(e==0){

                //creating socket and waiting for client connection
                Socket socket3 = server.accept();
                //read from socket to ObjectInputStream object
                ObjectInputStream oiu = new ObjectInputStream(socket3.getInputStream());
                //convert ObjectInputStream object to String
                String message3 = (String) oiu.readObject();
                System.out.println("Message Received: " + message3);
                if(message3.equalsIgnoreCase("exit")) ;
                }


           
            //close resources
            socket.close();
            //terminate the server if client sends exit request
            
            
        System.out.println("Shutting down Socket server!!");}
        //close the ServerSocket object
        
            }
      
    }
    
