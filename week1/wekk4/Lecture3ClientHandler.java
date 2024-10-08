package wekk4;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class Lecture3ClientHandler implements Runnable {
  private Socket conn;
  public Lecture3ClientHandler(Socket socket) {
    this.conn=socket;
  }
  public void run() {
    try {
      while (true){
        //This will print the date when there is a connection istablished
        Date now = new Date();
        //System.out.println(now.toString());

        Writer out = new OutputStreamWriter(conn.getOutputStream());
        out.write(now.toString( ) + "\r\n");
        out.flush();
      }
    }catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
