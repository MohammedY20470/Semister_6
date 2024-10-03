package week3;
import java.net.*;
public class Lecture2 {
    //today we will be working with the outputstream. and we will create two applications at least.
    //

    /*
     * so we will connect to whois.internic.net and the port is 43
        * the ather part will be about creating a program that 
        works with a higher level in the OSI stack
        and it is working with the http protocl as it is a web browser. 
        the website name is ipsource.???
     * 
     */
    public static void main(String[] args) {
/*         Scanner s = new Scanner(System.in);
        String the = s.nextLine();
        try(Socket socket =  new Socket("whois.internic.net", 43)){

            OutputStream output = socket.getOutputStream();
            Writer out = new OutputStreamWriter(output, "ASCII");
            out.flush();

            BufferedReader r= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = r.readLine())!= null) {
                System.out.println(line);
            }        
        }catch(Exception e){
            System.err.println(e);


        }*/
        try(Socket s = new Socket()){
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
