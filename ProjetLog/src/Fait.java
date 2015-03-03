
public class Fait {
	
	private String name;
	private double[] data;
	
	public Fait(String nom, double[] donnees){
		this.name = nom;
		this.data = donnees;
	}
	
	public double[] getData(){
		return this.data;
	}
	
	public String getName(){
		return this.name;
	}
}