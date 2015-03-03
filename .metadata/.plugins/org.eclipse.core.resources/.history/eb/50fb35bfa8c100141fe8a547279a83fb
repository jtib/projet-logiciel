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

	/** Méthode pour établir la liste des numéros des actions à effectuer
	 * 
	 * @param rules Liste des règles à appliquer 
	 * @param facts Liste des faits auxquels appliquer les règles
	 * @return la liste des actions à effectuer (sous forme de numéros)
	 */
	public Vector<Integer> aEffectuer(Regle[] rules, Fait[] facts){
		boolean b;
		Vector<Integer> listeActions = new Vector<Integer>();
			for(Regle r : rules){
				for(Fait f : facts){
					if(r.fact == f){
						b = (r.premise.eval());
						if(b){
							listeActions.add(r.action);
						}
					}
				}
			}
		return listeActions;
	}
}
