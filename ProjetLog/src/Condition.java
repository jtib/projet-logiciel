
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
		Class classe = c.getClass();
		boolean[] bool = (classe.equals(ComparaisonSimple.class) ? evalCompSimple(c,f) : evalCompDouble(c,f));
		return bool;
	}
	
	/** Methode pour evaluer une comparaison simple
	 * 
	 * @return la veracite de la comparaison
	 */
	public boolean[] evalCompSimple(Comparaison c, Fait f){
		double data [] = f.getData();
		boolean bool [] = new boolean[data.length];
		for(boolean b : bool){
			b = true;
		}
		//Si la comparaison s'applique à toutes les données
		if(c.getElement(0) == "all"){
			for(int i=0; i<data.length; i++){
				double a = data[i];
				c.setArg(0,String.valueOf(a));
				bool[i] = c.eval();
			}
		}
		//Sinon ne pas faire de for, évaluer seulement pour numéro concerné
		else{
			int i = Integer.valueOf(c.getElement(0));
			double a = data[i];
			c.setArg(0,String.valueOf(a));
			bool[i] = c.eval();
		}
		return bool;
	}
	
	
	
	
	
	/** Methode pour evaluer une comparaison double
	 * 
	 * @return la veracite de la comparaison
	 */
	public boolean[] evalCompDouble(Comparaison c, Fait f){
		double data [] = f.getData();
		boolean bool [] = new boolean[data.length];
		for(boolean b : bool){
			b = true;
		}
		int i = Integer.valueOf(c.getElement(0));
		int j = Integer.valueOf(c.getElement(2));
		double arg1 = data[i];
		double arg2 = data[j];
		c.setArg(0,String.valueOf(arg1));
		c.setArg(2, String.valueOf(arg2));
		bool[i] = c.eval();
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
