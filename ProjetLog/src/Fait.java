
public class Fait extends Predicat {

	private String name;
	public double[] data;//mettre en pas public plus tard

	public Fait(String nom, double[] donnees){
		this.name = nom;
		this.data = donnees;
	}
}