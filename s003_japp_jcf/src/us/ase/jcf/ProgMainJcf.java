package us.ase.jcf;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ProgMainJcf {

	public static void main(String[] args) {
		List<Plane> listPlanes = new Vector<Plane>(10);
		
		for(int i = 0; i < 20; i++){
			listPlanes.add(new Plane(101+i));
		}
		
		Plane temp = null;
		for(Iterator<Plane> it = listPlanes.iterator(); it.hasNext(); ){
			temp = it.next();
			temp.print();
		}
		
		
		
	}
}
