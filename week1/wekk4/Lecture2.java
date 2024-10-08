package wekk4;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Lecture2 {
  public static void main(String[] args) {
    /*
     * chapter 9 of java networking
     * server side part 2 (last part)
     *
     * making the app working multiple clients
     * and there will be a lab 1 exercise.
     *
     */

    /*
     * this application will work like this in terms of networking
     * if you have lets say two clients
     * you will have the dest ip will be same for the clints and also the ports,
     * but the sorce ip will be diffrent and may be the source
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
        try{
          Socket connection = s1.accept();
          Lecture3ClientHandler handler = new Lecture3ClientHandler(connection);
          Thread t = new Thread(handler);
          //each application will use a thread and you can limit the thread by using the thread pool;
          t.start(); // this will lunch the handler.run in that thread and
        } catch (Exception ex) {
          System.out.println("Catch2 : " + ex);
        }
      }
    } catch (Exception e) {
      System.out.println("Catch1 : "+ e);
    }
  }
}
