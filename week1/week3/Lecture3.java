package week3;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/*
 * H.W : 1- create an application that you will take the name of the clent and then print it out another time 
 *       2- what is the purpose of the last constructor that takes port, backlog, and the InetAddres data type and bindaddres
 */
public class Lecture3 {
  // the server side socket programming 
  // chapter 9 Java-networking-programming

  public static void main(String[] args) {
    
    /*this is a port that is created by JVM by asking the OS and if there 
      *is no other application using that port, that port will be opened and used

      *NOTE: but  if you are using UNIX machines if you want to create a port between 1-1023 
      *      you have to be the sudo to do this.
      */

    try(
      ServerSocket s1= new ServerSocket(5000 );
      /* 
       * if you give another int as the paramiter. 
       * you will dicide the number of the users that you want to use at one time. which is called the backlog
       * and that will be the second paramiter.  
       */
      ) {
        while (true){
          try {
            Socket connection = s1.accept();
            Date now = new Date();
            //This will print the date when there is a connection istablished 
            System.out.println(now.toString());

            Writer out = new OutputStreamWriter(connection.getOutputStream());
            out.write(now.toString( ) + "\n");
            out.flush();
          } catch (Exception ex) {
              System.out.println("Catch2 : " + ex);
          }
        }
    } catch (Exception e) {
      System.out.println("Catch1 : "+ e);
    }
    // try() {
        
    // } catch (Exception e) {
    // }
  }
}
