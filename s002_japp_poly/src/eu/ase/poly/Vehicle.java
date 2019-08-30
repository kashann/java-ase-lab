package eu.ase.poly;

public class Vehicle implements Movement {
	private float weight;
	
	public Vehicle() {
			
	}
	
	public Vehicle(float weight) {
		this.weight = weight;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	public String display(){
		return new String("Vehicle - w = " + this.weight);
	}
	
	@Override
	public void startEngine() {
		System.out.println("Vehicle starts engine.");
	}

	@Override
	public void stopEngine() {
		System.out.println("Vehicle stops engine.");  
	}
}
