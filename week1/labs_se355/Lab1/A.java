package labs_se355.Lab1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class A {
  public static void main(String[] args) {
    //generating a random number
    Random random = new Random();
    try(Socket socket = new Socket("localhost", 5000)){
      OutputStream os = socket.getOutputStream();
      Writer w = new OutputStreamWriter(os);

      //sending the number to Node B
      w.write( random.nextInt() + "\r\n");
      w.flush();
      System.out.println("Random number sent successfully to node B \n");
    }catch (IOException e){
      System.err.println(e.getMessage());
    }
    try(ServerSocket ss = new ServerSocket(5003)) {
      Socket serverSocket = ss.accept();

      //reading back the data from the server connection
      InputStream is = serverSocket.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      StringBuilder r = new StringBuilder();
      String line;

      while ((line = br.readLine()) != null) {
        r.append(line);
        r.append("\r\n");
      }
      //outputting the number to the display
      System.out.println("Received from client: " + r);
      System.out.println("The Program has finished successfully");
    }catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
