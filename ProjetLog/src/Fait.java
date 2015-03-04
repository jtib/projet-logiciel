import java.util.Hashtable;
import java.util.Vector;


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
	
	public Hashtable<Integer,Integer> aEffectuer(Vector<Regle> rules){
		boolean[] b;
		Hashtable<Integer,Integer> listeActions = new Hashtable<Integer,Integer>();
		for(Regle r : rules){
			Fait fait = r.getFait();
			if(fait == this){
				b = (r.getCondition().eval(this));
				for(int i=0; i<data.length; i++){
					if(b[i]){
						listeActions.put(i,r.getAction());
					}
				}
			}
		}
		return listeActions;
	}
}