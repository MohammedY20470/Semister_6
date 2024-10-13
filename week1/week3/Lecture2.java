package week3;

// Client Socket Programming - Part 3

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Lecture2 {
  //today we will be working with the outputstream. and we will create two applications at least.
  /*
   * so we will connect to whois.internic.net and the port is 43
   *    the ather part will be about creating a program that
   *  works with a higher level in the OSI stack
   *  and it is working with the http protocl as it is a web browser.
   *  the website name is ipsource.???
   */
  public static void main(String[] args) {
/*

 * This is application number one.
 *  this will ask the user to get some domain and then it will send it to the web service
 *  whois.internic.net which listens to port 43 and it will tells you some public data that is pubic about that domain.
 *    the point here is to get data from the user and send it via TCP/IP into the internet and then redding the comming data. i
 *
 *
    //getting the domain name and getting back the contact detail about that domain name.
   // getting the domain name as the standard system input
   //
    Scanner domain = new Scanner(System.in);
    System.out.println("Enter the name of the domain: ");
    String domainName = domain.nextLine();

    //creating the socket for connection to connect to internet
    try(Socket gettingTime= new Socket("whois.internic.net", 43)) {

      // creating the output object to send the data through the internet
      Writer out = new BufferedWriter(new OutputStreamWriter(gettingTime.getOutputStream(), "ASCII"));

      // writiing the data and preparing it to the OS to send it into the internet
      out.write(domainName+ "\r\n");
      // sending the data commpletely to the internet completely without waiting
      out.flush();

      System.out.println();
      //Print reply
      BufferedReader timeReader = new BufferedReader(new InputStreamReader(gettingTime.getInputStream()));
      StringBuilder lines;
      String line= null;
      while ((line = timeReader.readLine()) != null) {
        System.out.println(line);
      }

    }catch (Exception catch1) {
      System.err.println(catch1.getMessage());
    }*/




    /* The 2nd applicatio start here
     * This application will act like a browser and will use the Http protocol to reach out to other webservers
     * the website name is ---> ipinfo.io
     * and the port number is ---->80
     *
     */

    try(Socket connection= new Socket("ipinfo.io",80);){
      InputStream inputStream=connection.getInputStream();
      OutputStream outputStream=connection.getOutputStream();

      BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
      Writer writer=new OutputStreamWriter(outputStream, "ASCII");

      writer.write("GET / HTTP/1.0\n");
      //if you want to make distribute the pay load you have to at least add these two lines of code:
      //writer.flush();
      //Thread.sleep(5000);
      writer.write("Host: ipinfo.io\n");
      writer.write("\n");
      writer.flush();
      //Read Reply
      StringBuilder responseFromNet=new StringBuilder();
      String line = null;
      while((line=reader.readLine())!=null){
        responseFromNet.append(line);
        responseFromNet.append("\r\n");
      }
      System.out.println(responseFromNet.toString());

    }catch (Exception catch1){
      System.err.println(catch1.getMessage());
    }
  }
}
