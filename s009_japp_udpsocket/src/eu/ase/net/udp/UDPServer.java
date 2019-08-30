package eu.ase.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		byte[] bufRecv = null;
		byte[] bufResp = null;
		
		// could be re-factored with "try with resources"
		try{
			socket = new DatagramSocket(7778);
			//initial socketul este null si il aloc o singura data
			while(true) {
				bufRecv = new byte[256];//regula std este ca intr-un pachet sa pui maxim 256 elemente
				
				// Receive request
				DatagramPacket packet = new DatagramPacket(bufRecv, bufRecv.length);
				socket.receive(packet);
				
				//bufRecv = packet.getData(); // nu mai e nevoie, e doar pt scop didactic
				System.out.println("Client says: " + new String(bufRecv));
				
				// figure out the response
				String respString = new String("OK");
				bufResp = respString.getBytes();
				
				// send the response at the client address and port
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				DatagramPacket packetResp = new DatagramPacket(bufResp, bufResp.length, address, port);
				socket.send(packetResp);			
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally{
			if(socket != null){
				socket.close();
			}
		}		
	}
}
