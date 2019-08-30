package us.ase.jcf;

public class Country {
	private int idCountry;
	private String codeName;
	
	public Country(int idCountry, String codeName){
		this.idCountry = idCountry;
		this.codeName = codeName;
	}
	
	public void print(){
		System.out.println("Country - id = " + this.idCountry + ", name = " + this.codeName);
	}
}
