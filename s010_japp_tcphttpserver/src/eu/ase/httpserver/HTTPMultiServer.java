package eu.ase.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPMultiServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		boolean listening = true;
		
		try {
			int port = Integer.parseInt(args[0]);
			serverSocket = new ServerSocket(port);
			System.out.println("Server DICE listens in port: " + port);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		while(listening){
			//try (Socket client = serverSocket.accept()) {
			try {
				Socket client = serverSocket.accept();
				
				HTTPMultiServerThread objClient = new HTTPMultiServerThread(client);
				objClient.start();
				
				//client.close(); // wrong, echiv cu try with resources comentat
			} catch(IOException ioex) {
				ioex.printStackTrace();
			}
		}
		
		try {
			if(serverSocket != null)
				serverSocket.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}		
	}
}