package week3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Lecture3 {
  // the server side socket programming 
  // chapter 9 Java-networking-programming

  public static void main(String[] args) {
    
    /*this is a port that is created by JVM by asking the OS and if there 
      *is no other application using that port, that port will be opened and used
      */
    try(
      ServerSocket s1= new ServerSocket(5000 );
      ) {

        Socket connection = s1.accept();
        Date now = new Date();
        System.out.println(now.toString());
      
    } catch (Exception e) {
    }
    // try() {
        
    // } catch (Exception e) {
    // }
  }


}
