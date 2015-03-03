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
	public Vector<Integer> aEffectuer(Fait[] facts){
		boolean[] b;
		Vector<Integer> listeActions = new Vector<Integer>();
		for(Fait f : facts){
			double[] data = f.getData();
			if(this.fact == f){
				b = (this.premise.eval(f));
				for(int i=0; i<data.length; i++){
					if(b[i]){
						listeActions.add(this.action);
					}
				}
			}
		}
		return listeActions;
	}
}
