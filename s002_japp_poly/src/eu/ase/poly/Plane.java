package eu.ase.poly;

public class Plane extends Vehicle {
	private float capacity;
	private int enginesNo;
	
	public Plane(){
		
	}
	
	public Plane(float weight, float capacity, int enginesNo){
		super(weight);
		this.capacity = capacity;
		this.enginesNo = enginesNo;
	}
	
	@Override
	public String display(){
		return new String("Plane - w = " + this.getWeight() +
				", capacity = " + this.capacity + 
				", enginesNo = " + this.enginesNo);
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public int getEnginesNo() {
		return enginesNo;
	}

	public void setEnginesNo(int enginesNo) {
		this.enginesNo = enginesNo;
	}
}
