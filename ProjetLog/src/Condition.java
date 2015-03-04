
public class Condition {
	
	//remplacer par un vecteur
	Comparaison[] comparaisons;
	
	//creer un nouveau
	public Condition(Comparaison[] compa){
		this.comparaisons = compa;
	}
	
	//ajouter methode pour ajouter comparaison au vecteur comparaisons
	
	/** Methode pour evaluer une comparaison
	 * 
	 * @return la veracite de la comparaison
	 */
	public boolean[] evalComp(Comparaison c, Fait f){
		double data [] = f.getData();
		boolean bool [] = new boolean[data.length];
		for(boolean b : bool){
			b = false;
		}
		//Si la comparaison s'applique à toutes les données
		if(c.getElement(0) == "all"){
			for(int i=0; i<data.length; i++){
				double a = data[i];
				c.setFirstArg(a);
				bool[i] = c.eval();
			}
		}
		//Sinon ne pas faire de for, évaluer seulement pour numéro concerné
		else{
			int i = Integer.valueOf(c.getElement(0));
			double a = data[i];
			c.setFirstArg(a);
			bool[i] = c.eval();}
		return bool;
	}
	
	/** Methode pour evaluer la condition
	 * 
	 * @return la veracite de la condition
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
			//on evalue la veracite de la comparaison pour le fait
			bc = evalComp(this.comparaisons[i], f);
			//puis pour chaque valeur on combine les resultats
			for(int j=0; j<data.length; j++){
				b[j] = b[j] && bc[j];
			}
		}
		return b;	
	}
}
