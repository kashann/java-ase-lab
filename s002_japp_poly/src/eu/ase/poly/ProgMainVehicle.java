package eu.ase.poly;

public class ProgMainVehicle {
	public static void main(String[] args) {
		Vehicle v = null;
		Auto a = new Auto(1360, 5);
		Plane p = new Plane(400000, 450, 4);
				
		v = a;
		System.out.println(v.display());
		
		v = p;
		System.out.println(v.display());
	}	
}
