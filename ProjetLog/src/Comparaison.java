
public class Comparaison {
	
	private String[] comp;
	
	public Comparaison(String op, double b){
		this.comp = new String[3];
		comp[1] = op;
		comp[2] = String.valueOf(b);
	}
	
	/** Méthode pour modifier le premier terme de la comparaison
	 * 
	 * @param a La nouvelle valeur du premier terme 
	 */
	public void setFirstArg(double a){
		this.comp[0] = String.valueOf(a);
	}
	
	/** Méthode pour obtenir un terme de la comparaison
	 * 
	 * @return le terme demandé
	 */
	public double getElement(int i){
			return Double.valueOf(this.comp[i]);
	}
	
	/** Méthode pour évaluer une comparaison
	 * 
	 * @return un booléen qui indique si la comparaison est vraie ou fausse
	 */
	public boolean eval(){
		boolean bool;
		double a = Double.valueOf(this.comp[0]);
		double b = Double.valueOf(this.comp[2]);
		switch(this.comp[1]){
			case "<": bool = a < b;
				break;
			case ">": bool = a > b;
				break;
			case "<=": bool = a <= b;
				break;
			case ">=": bool = a >= b;
				break;
			case "==": bool = a == b;
				break;
			default: bool = true;
				break;
		}
		return bool;
	}
}
