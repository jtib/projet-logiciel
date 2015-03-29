import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;
import java.util.List;
//import java.util.Map;
import java.util.Vector;


public class Fait {

	private String name;
	private List<Double> data;

	public Fait(String nom, List<Double> donnees){
		this.name = nom;
		this.data = donnees;
	}
	
	public List<Double> getData(){
		return this.data;
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Pair<Integer,List<Double>>> aEffectuer(Vector<Regle> rules){
		boolean[] b;
		List<Pair<Integer,List<Double>>> listeActions = new ArrayList<Pair<Integer,List<Double>>>();
		for(Regle r : rules){
			Fait fait = r.getFait();
			if(fait == this){
				b = (r.getCondition().eval(this));
				for(int i=0; i<data.size(); i++){
					List<Double> lesActions = new ArrayList<Double>();
					Pair<Integer,List<Double>> paireSujetActions = new Pair<Integer,List<Double>>(i,lesActions);
					if(b[i]){
						//i permet de retrouver a quoi s'applique l'action
						//Si la condition s'applique, on ajoute l'action au vecteur d'actions du numéro i du fait
						//numero d'action en tant que double pour respecter les conventions de notation d'un fait
						paireSujetActions.getValue().add((double)r.getAction());
					}
					//A la fin, on ajoute la paire(Sujet + actions associées) a la liste d'actions
					listeActions.add(paireSujetActions);
				}
			}
		}
		return listeActions;
	}
}