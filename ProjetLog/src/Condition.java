
public class Condition {
	
	//remplacer par un vecteur
	Comparaison[] comparaisons;
	
	//creer un nouveau
	public Condition(Comparaison[] compa){
		this.comparaisons = compa;
	}
	
	//ajouter m�thode pour ajouter comparaison au vecteur comparaisons
	
	/** M�thode pour �valuer une comparaison
	 * 
	 * @return la v�racit� de la comparaison
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
	
	/** M�thode pour �valuer la condition
	 * 
	 * @return la v�racit� de la condition
	 */
	public boolean[] eval(Fait f){
		double[] data = f.getData();
		boolean b [] = new boolean[data.length];
		//Probl�me : si la condition ne s'applique � rien, restera true
		for(int k=0; k<b.length; k++){
			b[k]=true;
		}
		boolean bc [];
		//pour chaque comparaison dans la condition
		for(int i = 0; i < this.comparaisons.length; i++){
			//on �value la v�racit� de la comparaison pour toutes les valeurs indiqu�es dans le fait
			bc = evalComp(this.comparaisons[i], f);
			//puis pour chaque valeur on combine les r�sultats
			for(int j=0; j<data.length; j++){
				b[j] = b[j] && bc[j];
			}
		}
		return b;	
	}
}
