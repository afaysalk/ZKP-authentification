

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
        int g =3;
        String password =" My password ";
        int x=(password).hashCode();   
        long y=(long)Math.pow(g,x);

            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Envoi requete vers serveur");
           
            oos.writeObject(y);

      //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                long v=2;
                long t=(long)Math.pow(g,v);
                oos.writeObject(v);
            

           


                
                //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                long r=v-c*x;
                oos.writeObject(r);
            



            oos.close();
            Thread.sleep(100);
            System.out.println("Connexion acceptée");
        }
        
            
        }
    
