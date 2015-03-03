
public class Condition {
	
	//remplacer par un vecteur
	Comparaison[] comparaisons;
	
	//creer un nouveau
	public Condition(Comparaison[] compa){
		this.comparaisons = compa;
	}
	
	//ajouter mŽthode pour ajouter comparaison au vecteur comparaisons
	
	/** MŽthode pour Žvaluer une comparaison
	 * 
	 * @return la vŽracitŽ de la comparaison
	 */
	public boolean[] evalComp(Comparaison c, Fait f){
		double data [] = f.getData();
		boolean bool [] = new boolean[data.length];
		for(int i=0; i<data.length; i++){
			double a = data[i];
			c.setFirstArg(a);
			bool[i] = c.eval();
		}
		return bool;
	}
	
	/** MŽthode pour Žvaluer la condition
	 * 
	 * @return la vŽracitŽ de la condition
	 */
	public boolean[] eval(Fait f){
		double[] data = f.getData();
		boolean b [] = new boolean[data.length];
		for(int k=0; k<b.length; k++){
			b[k]=true;
		}
		boolean bc [];
		//pour chaque comparaison dans la condition
		for(int i = 0; i < this.comparaisons.length; i++){
			//on Žvalue la vŽracitŽ de la comparaison pour toutes les valeurs indiquŽes dans le fait
			bc = evalComp(this.comparaisons[i], f);
			//puis pour chaque valeur on combine les rŽsultats
			for(int j=0; j<data.length; j++){
				b[j] = b[j] && bc[j];
			}
		}
		return b;	
	}
}
