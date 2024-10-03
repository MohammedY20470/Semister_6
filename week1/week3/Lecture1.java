package week3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Lecture1 {
    //today will be about reading data from tcp sockets. 
    //these should almost always have these two points:
    // 1-you are the one who created the connection 
    // 2- and you are the client. 
    // * input and output is always dependable 
    // * the data is always the payload that we get it from TCP

    public static void main(String[] args) {
        try(Socket s = new Socket("time.nist.gov", 13)){


            // the is a way to fix the source ip addres and source port number as the 3rd and 4th arguments.
            InputStream in = s.getInputStream();
            InputStreamReader ins = new InputStreamReader(in);
            int b =0;
            while ((b= in.read()) != -1)
            { 
                System.out.print((char)b);                
            }
             
            // Socket s1= new Socket("172.217.20.78", 80,);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
}
// change the socket.getnputStream to System.in