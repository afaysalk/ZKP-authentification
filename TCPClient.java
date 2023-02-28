

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
        int g=3;
        int p=7;
        int x=15;
        int y=(int)Math.pow(g,x)%p;
        
        for(int i=0; i<10 ; i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            Random rand = new Random();
            int r = rand.nextInt(200); 
            long u=((long)(Math.pow(g,r)%p));
            oos.writeObject(u);
            
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            int e = (int) ois.readObject();
            System.out.println("Challenge " + e);

            if (e==1) {
                //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Sending v=x+r ");
                long v=x+r;
                oos.writeObject(v);
            }

            if (e==0) {
                //close resources
                Thread.sleep(100);
                //establish socket connection to server
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Sending v=r ");
                long v=r;
                oos.writeObject(v);
            }

        }
            
        }
    
}