package eu.ase.io.serialization;

import java.io.Serializable;
import java.net.URL;

public class ObjectsGraph implements Serializable{
	public URL o1;
	public URL o2;
	
	public ObjectsGraph(URL op1, URL op2){
		this.o1 = op1;
		this.o2 = op2;
	}
	
	@Override
	public String toString(){
		return new String("o1 = " + this.o1 + ", o2 = " + this.o2);
	}

}
