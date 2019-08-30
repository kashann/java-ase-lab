package eu.ase.io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

public class ObjectsSave {
	public static void main(String[] args){
		ObjectsGraph og = null;
		
		try{
			System.out.println("Saving objects ...");
			
			FileOutputStream fout = new FileOutputStream("test3.txt");
			ObjectOutputStream sout = new ObjectOutputStream(fout);
			
			URL o1 = new URL("https://www.google.com");
			URL o2 = o1; //shallow copy
			URL o3 = o1;
			
			og = new ObjectsGraph(o1, o2);
			sout.writeObject(og);
			sout.reset();
			sout.writeObject(o3);
			sout.flush();
			
			System.out.println("og written: " + og);
			System.out.println("o3 written: " + o3);
			
			boolean exjvm = ((og.o1 == o3) && (og.o1 == og.o2)); //da true pentru ca == compara adrese
			System.out.println("exjvm boolean = " + exjvm);
			
			sout.close();
			fout.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
