import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;
import java.util.List;
//import java.util.Map;
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
	
	public List<Pair<Integer,List<Integer>>> aEffectuer(Vector<Regle> rules){
		boolean[] b;
		List<Pair<Integer,List<Integer>>> listeActions = new ArrayList<Pair<Integer,List<Integer>>>();
		//List<Integer> lesActions = new ArrayList<Integer>();
		for(Regle r : rules){
			Fait fait = r.getFait();
			if(fait == this){
				b = (r.getCondition().eval(this));
				//
				for(int i=0; i<data.length; i++){
					List<Integer> lesActions = new ArrayList<Integer>();
					Pair<Integer,List<Integer>> paireSujetActions = new Pair<Integer,List<Integer>>(i,lesActions);
					if(b[i]){
						//i permet de retrouver a quoi s'applique l'action
						//Si la condition s'applique, on ajoute l'action au vecteur d'actions du numéro i du fait
						paireSujetActions.getValue().add(r.getAction());
					}
					//À la fin, on ajoute la paire(Sujet + actions associées) à la liste d'actions
					listeActions.add(paireSujetActions);
				}
			}
		}
		return listeActions;
	}
}