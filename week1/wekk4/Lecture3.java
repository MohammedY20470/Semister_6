package wekk4;

public class Lecture3 {
  public static void main(String[] args) {
    /*
     * Topic: Complex data Transfers
     * Reference: Elliotte Ch3 & Ch9
     *
     *
     * In java you can not send data to other node as objects very easily.
     * why? lets imagine why?
     * in that class we did the encoding and decoding manually.
     * so it will look like it will have these problems->
     * 1- you can not send every single field because some might be private.
     * 2- you mill be using to much bandwidth, for example, to send a float as string you will use at least 7 bytes, instead of 4. and this will make your system very slow.
     * 3- complex data types will be too complex, and you should have dozens of Writer object for every field.
     * 4- because you are sending the data in sequence, you should do the read in the same sequence, if you change the sequence in one step you should do it in the other one too, and that will brake the system very easily.
     *
     * these problems are there because you treat Complex Data Types as Values, not as they needed to be.
     *
     * We can fix these problems in many ways.
     * one of them, and the one that we are going to use is great if your client and server both are written in java.
     *
     * for this solution to be effective, we should never use Writer and Reader again, instead we will be using ObjectInputStream, or ObjectOutputStream.
     * 
     *
     *
     */
  }
}
