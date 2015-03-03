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

	/** Méthode pour établir la liste des numéros des actions à effectuer
	 * 
	 * @param facts Liste des faits auxquels appliquer les règles
	 * @return la liste des actions à effectuer (sous forme de numéros)
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
