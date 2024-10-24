package week2;

import java.net.*;
public class Lecture_3 {
    /*
     * what is the diffrence between socket Address remoteyahoo = socket.getRemoteSocketAddress();
     * what is the diffrence between socket Address Localyahoo = socket.getLocaleSocketAddress();
     */


    //socket programming chapter 8
    //remmember that your application sitts on top of the TCP/IP module. 
    // and all the layers are covered by the Operating system. 
    // and you can interact with them by an api that is called The socket API 
    // to elaborate more the socket is one end of the connections. 
    // so you need at least two socket to create a connection.


    //you need 6 piece of information for the connection 
    // src and dst port
    // src and dst ip 
    // src and dst mac address
    
    public static void main(String[] args) {
        // try {
        //     Socket toGoogle= new Socket("216.58.212.14", 80);
        //     //to create a connection you will see 3 packets. 
        //     // 2 is sync packets. 
        //     // 1 is akc 
        //     // also you will have 3 packets to close the connection
        //     // fin is a protocol that is that is for closing the connection grasefuly
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
        for(int i =1; i<8088; i++){
            try {
                Socket local= new Socket("127.0.0.1",i);
                System.out.println(i);
            } catch (Exception e) {
//                System.err.println(e);
            }
        }
    }
}
