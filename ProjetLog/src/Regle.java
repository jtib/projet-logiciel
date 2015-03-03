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

<<<<<<< Updated upstream
	/** Méthode pour établir la liste des numéros des actions à effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les règles
	 * @return la liste des actions à effectuer (sous forme de numéros)
=======
	/** M�thode pour �tablir la liste des num�ros des actions � effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les r�gles
	 * @return la liste des actions � effectuer (sous forme de num�ros)
>>>>>>> Stashed changes
	 */
	public Vector<Pair<Integer,Integer>> aEffectuer(Fait[] facts){
		boolean[] b;
		Vector<Pair<Integer,Integer>> listeActions = new Vector<Pair<Integer,Integer>>();
		for(Fait f : facts){
			double[] data = f.getData();
			if(this.fact == f){
				b = (this.premise.eval(f));
				for(int i=0; i<data.length; i++){
					if(b[i]){
						Pair<Integer,Integer> paire = new Pair<Integer,Integer>(i,this.action);
						listeActions.add(paire);
					}
				}
			}
		}
		return listeActions;
	}
}
