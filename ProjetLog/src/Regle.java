import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Regle {

	private Fait fact;
	private Condition premise;
	private int action;

	public Regle(Fait fait, Condition premisse, int numAction){
		this.fact = fait;
		this.premise = premisse;
		this.action = numAction;
	}

	public Fait getFait(){
		return this.fact;
	}

	public Condition getCondition(){
		return this.premise;
	}

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
			double[] data = f.getData();
			if(this.fact == f){
				b = (this.premise.eval(f));
				for(int i=0; i<data.length; i++){
					List<Integer> lesActions = new ArrayList<Integer>();
					Pair<Integer,List<Integer>> paireSujetActions = new Pair<Integer,List<Integer>>(i,lesActions);
					if(b[i]){
						// i permet de retrouver à quoi s'applique l'action
						//Si la condition s'applique, on ajoute l'action au vecteur d'actions du numéro i du fait
						paireSujetActions.getValue().add(this.getAction());
					}
					listeActions.add(paireSujetActions);
				}
			}
		}
		return listeActions;
	}
}
