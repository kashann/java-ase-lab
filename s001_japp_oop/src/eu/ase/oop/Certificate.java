package eu.ase.oop;

public class Certificate {
	private int id;
	private String issuerName;
	
	public Certificate(int id, String name) {
		this.id = id;
		this.issuerName = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIssuerName() {
		return this.issuerName;
	}
	
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}	
}