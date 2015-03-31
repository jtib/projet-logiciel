import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Regle {

	private Fait fact;
	private Condition premise;
	private int action;

	/** Constructeur
	 * 
	 * @param fait : le fait auquel s'applique la regle si son nom correspond
	 * @param premisse : la condition a respecter pour que la regle s'applique
	 * @param numAction : le numero de l'action a realiser si la regle s'applique
	 */
	public Regle(Fait fait, Condition premisse, int numAction){
		this.fact = fait;
		this.premise = premisse;
		this.action = numAction;
	}

	/**
	 * 
	 * @return le fait auquel s'applique la regle
	 */
	public Fait getFait(){
		return this.fact;
	}

	/**
	 * 
	 * @return la premisse de la regle
	 */
	public Condition getCondition(){
		return this.premise;
	}

	/**
	 * 
	 * @return le numero de l'action a effectuer si la regle s'applique
	 */
	public int getAction(){
		return this.action;
	}

	/** Methode pour etablir la liste des numeros des actions a effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les regles
	 * @return la liste des actions a effectuer (sous forme de numeros)
	 */
	public List<Pair<Integer,List<Integer>>> aEffectuer(Vector<Fait> facts){
		boolean[] b;
		List<Pair<Integer,List<Integer>>> listeActions = new ArrayList<Pair<Integer,List<Integer>>>();	
		for(Fait f : facts){
			List<Double> data = f.getData();
			if(this.fact.getName() == f.getName()){
				b = (this.premise.eval(f));
				for(int i=0; i<data.size(); i++){
					List<Integer> lesActions = new ArrayList<Integer>();
					Pair<Integer,List<Integer>> paireSujetActions = new Pair<Integer,List<Integer>>(i,lesActions);
					if(b[i]){
						// i permet de retrouver à quoi s'applique l'action
						//Si la condition s'applique, on ajoute l'action au vecteur d'actions du numéro i du fait
						paireSujetActions.getValue().add(this.getAction());
					}
					listeActions.add(paireSujetActions);
					//Fait faitSupplementaire = new Fait(String.valueOf(i),lesActions);
					//facts.add(faitSupplementaire);
				}
			}
		}
		return listeActions;
	}
}
