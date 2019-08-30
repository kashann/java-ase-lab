package eu.ase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgMainIO {

	public static void main(String [] args){
		double[] prices = new double[] {19.99, 14.11, 23.21};
		int[] units = new int[] {8, 9, 10};
		String[] descs = new String[] {"T-Shirt", "Mug", "Pen"};
		
		DataOutputStream out = null;
		DataInputStream in = null;
		
		try{
			FileOutputStream fos = new FileOutputStream("test.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			out = new DataOutputStream(bos);
			
			for(int i = 0; i < prices.length; i++){
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
			
			out.close();
			
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			double price; int unit;	String desc;
			double total = 0.0;
			try{
				while(true){
					price = in.readDouble();
					unit = in.readInt();
					desc = in.readUTF();
					total = total + (price * unit);
					System.out.printf("Product %s, unit = %d, Price = %f \n", desc, unit, price);
				}
			}catch(EOFException eofe){
				System.out.println("Total = " + total);
				in.close();
			}
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}

