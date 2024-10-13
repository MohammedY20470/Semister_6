package labs_se355.Lab1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class C {
  public static void main(String[] args) {
    StringBuilder serviceReq = new StringBuilder(); //Storing the the data you need to serve

    //opening a server with localhost network and port number 5000 like it it the first kluster in the cluster
    try(
            ServerSocket ss = new ServerSocket(5001)
    ) {
      //accepting only one request from the clients
      Socket serverSocket = ss.accept();
      // accepting the request and reading the data
      InputStream is = serverSocket.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      //going throw the inputs that came from serviceRequest
      while ((line = br.readLine()) != null) {
        serviceReq.append(line);
      }
      //outputting some Info
      System.out.println("Data received from Node B");
      //watting a bit till the other server is activated or simulating the latency of Internet
      Thread.sleep(100);
    }catch (Exception e) {
      System.err.println(e.getMessage());
    }
    try(
            Socket socket = new Socket("localhost", 5002)
    ){
      //sending back the input data to the next node
      OutputStream os = socket.getOutputStream();
      Writer w = new OutputStreamWriter(os);
      w.write(serviceReq+ "\n");
      w.flush();
      System.out.println("data sent to Node D");
      //closing up the connection
    }catch (IOException e){
      System.err.println(e.getMessage());
    }
  }
}

