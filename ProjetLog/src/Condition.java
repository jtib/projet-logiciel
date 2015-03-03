
public class Condition {
	
	//remplacer par un vecteur
	Comparaison[] comparaisons;
	
	//creer un nouveau
	public Condition(Comparaison[] compa){
		this.comparaisons = compa;
	}
	
	//ajouter méthode pour ajouter comparaison au vecteur comparaisons
	
	/** Méthode pour évaluer une comparaison
	 * 
	 * @return la véracité de la comparaison
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
	
	/** Méthode pour évaluer la condition
	 * 
	 * @return la véracité de la condition
	 */
	public boolean[] eval(Fait f){
		double[] data = f.getData();
		boolean b [] = new boolean[data.length];
		//Problème : si la condition ne s'applique à rien, restera true
		for(int k=0; k<b.length; k++){
			b[k]=true;
		}
		boolean bc [];
		//pour chaque comparaison dans la condition
		for(int i = 0; i < this.comparaisons.length; i++){
			//on évalue la véracité de la comparaison pour toutes les valeurs indiquées dans le fait
			bc = evalComp(this.comparaisons[i], f);
			//puis pour chaque valeur on combine les résultats
			for(int j=0; j<data.length; j++){
				b[j] = b[j] && bc[j];
			}
		}
		return b;	
	}
}
