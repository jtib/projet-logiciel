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
	
	public Vector<Pair<Integer,Integer>> aEffectuer(Vector<Regle> rules){
		boolean[] b;
		Vector<Pair<Integer,Integer>> listeActions = new Vector<Pair<Integer,Integer>>();
		for(Regle r : rules){
			Fait fait = r.getFait();
			if(fait == this){
				b = (r.getCondition().eval(this));
				for(int i=0; i<data.length; i++){
					if(b[i]){
						Pair<Integer,Integer> paire = new Pair<Integer,Integer>(i,r.getAction());
						listeActions.add(paire);
					}
				}
			}
		}
		return listeActions;
	}
}
