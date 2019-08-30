package eu.ase.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPMultiServerThread extends Thread {
	private Socket  socket = null;
	
	public HTTPMultiServerThread(Socket s) {
		this.socket = s;
	}
	
	@Override
	public void run() {
		OutputStream os;
		PrintWriter out = null;
		InputStream is;
		BufferedReader in = null;
		
		try {
			os = this.socket.getOutputStream();
			out = new PrintWriter(os, true);
			
			is = socket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
		}
	}
}
