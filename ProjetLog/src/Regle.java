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
