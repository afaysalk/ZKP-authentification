

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.lang.Math;
/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class TCPClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        int p=10;
        int q=3;
        int a=1;
        int s=2;
        int v=1;
        
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Envoi requete vers serveur");
            Random rand = new Random();
            int r = rand.nextInt(3); 
            long x=(long)Math.pow(a,r)%p;
            String message =" Vive me ";
            int e=(message+x).hashCode();    
            int y=(r+(s*e))%p;
            oos.writeObject(message);

      //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                
              
                
                oos.writeObject(e);
            

           
                //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
               
                oos.writeObject(y);
            



            oos.close();
            Thread.sleep(100);
            System.out.println("Connexion acceptée");
        }
        
            
        }
    
