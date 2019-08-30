package src.eu.ase.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPMultiServerThread extends Thread {
	private Socket socket = null;
	public HTTPMultiServerThread(Socket s) {
		super("thread for processing client");
		this.socket = s;
	}
@Override
public void run() {
	OutputStream os = null;
	PrintWriter out =null;
	
	InputStream is = null; 
	BufferedReader in =null;
	
	String inputLine =null;
	String outputLine =null;
	
	try {
		os=socket.getOutputStream();
		out = new PrintWriter(os, true);
		is = socket.getInputStream();
		in = new BufferedReader(new InputStreamReader(is));
	}catch (IOException ioe) {
		ioe.printStackTrace();
	}finally {
		try {
			if(out!=null)out.close();
			if(in!=null) in.close();
			if(socket!=null) socket.close();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
}
