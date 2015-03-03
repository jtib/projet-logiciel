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
	
	/** M�thode pour �tablir la liste des num�ros des actions � effectuer
	 * 
	 * @param rules Liste des r�gles � appliquer 
	 * @param facts Liste des faits auxquels appliquer les r�gles
	 * @return la liste des actions � effectuer (sous forme de num�ros)
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
