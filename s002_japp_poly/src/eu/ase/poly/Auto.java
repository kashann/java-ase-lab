package eu.ase.poly;

public class Auto extends Vehicle {
	private int doorsNo;

	public Auto() {		
		
	}
	
	public Auto(float weight, int doorsNo){
		super(weight); //apeleaza constructorul din vehicle, trebuie sa fie pe prima linie a constructorului
		this.doorsNo = doorsNo;
	}
	
	public int getDoorsNo(){
		return this.doorsNo;
	}
	
	public void setDoorsNo(int doorsNo){
		this.doorsNo = doorsNo;
	}
	
	@Override
	public String display() {
		return new String("Auto - w = " + this.getWeight() + ", doors = " + this.doorsNo);
	}
}