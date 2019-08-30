package eu.ase.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPClient {

	public static void main(String[] args) throws IOException{
		// get a datagram socket
		DatagramSocket clientSocket = new DatagramSocket();
		
		// send request
		byte[] buf = new byte[256]; // avem 256 de octeti din care primii 5 ocupati
		buf[0] = 'S';
		buf[1] = 'a';
		buf[2] = 'l';
		buf[3] = 'u';
		buf[4] = 't';
		//buf = new String("Salut").getBytes(); //e diferit fata de mai sus (doar 5 octeti toti ocupati)
		
		//InetAddress address = InetAddress.getByName("127.0.0.1"); // hardcoded
		InetAddress address = InetAddress.getByName(args[0]); // input din linie de comanda
		int port = Integer.parseInt(args[1]); // 7778
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
		clientSocket.send(packet);
		
		// get response
		byte[] bufResp = new byte[256];
		packet = new DatagramPacket(bufResp, bufResp.length);
		clientSocket.receive(packet);
		
		// display the response
		String recieved = new String(packet.getData());
		System.out.println("Client from server recieved = " + recieved);
		
		// close socket
		clientSocket.close();
	}

}
