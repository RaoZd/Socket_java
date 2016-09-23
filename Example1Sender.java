import java.net.*;
import java.io.*;

public class Example1Sender {

    // 主函数需要3个参数：1、目的机的IP地址；2、目的机的端口号（必须与接收方一致）；3、要传递的消息
public static void main(String[] args) {
      if (args.length != 3)
         System.out.println
            ("This program requires three command line arguments");
      else {
         try {
  		    InetAddress receiverHost = InetAddress.getByName(args[0]);
  		    int receiverPort = Integer.parseInt(args[1]);
            String message = args[2];

		// instantiates a datagram socket for sending the data
   	      	DatagramSocket	mySocket = new DatagramSocket();           
            byte[ ] buffer = message.getBytes( );                                     
            DatagramPacket datagram = 
               new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);

            //mySocket.setSoTimeout(3000);
            mySocket.send(datagram);
            mySocket.close( );
         } // end try
	 catch (Exception ex) {
       ex.printStackTrace( );
	 }
      } // end else
   } // end main
} // end class		
