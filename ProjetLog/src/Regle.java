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
	/** MÃ©thode pour Ã©tablir la liste des numÃ©ros des actions Ã  effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les rÃ¨gles
	 * @return la liste des actions Ã  effectuer (sous forme de numÃ©ros)
=======
	/** MŽthode pour Žtablir la liste des numŽros des actions ˆ effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les rgles
	 * @return la liste des actions ˆ effectuer (sous forme de numŽros)
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
