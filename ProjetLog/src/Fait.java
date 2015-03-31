import java.util.ArrayList;
import java.util.List;


public class Fait {

	private String name;
	private List<Double> data;

	/** Constructeur
	 * 
	 * @param nom : le nom du fait
	 * @param donnees : les donnees associees
	 */
	public Fait(String nom, List<Double> donnees){
		this.name = nom;
		this.data = donnees;
	}
	
	/** Pour obtenir la partie "donnees" d'un fait
	 * 
	 * @return les donnees du fait
	 */
	public List<Double> getData(){
		return this.data;
	}
	
	/**
	 * 
	 * @return le nom d'un fait
	 */
	public String getName(){
		return this.name;
	}
	
	/** Methode pour etablir la liste des actions a effectuer
	 * 
	 * @param rules Liste des regles a appliquer (si possible) aux faits 
	 * @return la liste des actions a effectuer (sous forme de numeros)
	 */
	public List<Pair<Integer,List<Double>>> aEffectuer(List<Regle> rules){
		boolean[] b;
		List<Pair<Integer,List<Double>>> listeActions = new ArrayList<Pair<Integer,List<Double>>>();
		for(Regle r : rules){
			Fait fait = r.getFait();
			if(fait.getName() == this.getName()){
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