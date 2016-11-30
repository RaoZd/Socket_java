import java.net.*;

public class Example2ReceiverSender {

   public static void main(String[] args) {
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {      
  		      InetAddress receiverHost = InetAddress.getByName(args[0]);
              int receiverPort = Integer.parseInt(args[1]);
  		      int myPort = Integer.parseInt(args[2]);
              String message = args[3];
   	          MyDatagramSocket mySocket = new MyDatagramSocket(myPort);  
              // instantiates a datagram socket for both sending and receiving data
			  // First wait to receive a datagram from the socket
              System.out.println(mySocket.receiveMessage());
		      // Now send a message to the other process.
              mySocket.sendMessage( receiverHost, receiverPort, message);
			  mySocket.close( );
         } // end try
	     catch (Exception ex) {
            ex.printStackTrace( );
	      } //end catch
      } //end else
   } //end main 
} //end class
