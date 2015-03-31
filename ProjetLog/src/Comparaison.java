
public class Comparaison {
	
	private String[] comp;

	public Comparaison(String arg1, String op, String arg2){
		this.comp = new String[3];
		comp[0] = arg1;
		comp[1] = op;
		comp[2] = arg2;
	}
	
	/** Methode pour modifier un terme de la comparaison
	 * 
	 * @param a La nouvelle valeur du terme concerne
	 */
	public void setArg(int i, String x){
		this.comp[i] = x;
	}
	
	
	/**
	 * 
	 * @param i : indice de l'element a renvoyer
	 * @return l'element correspondant a l'indice demande (0 : (indice du) premier argument, 1 : operande, 2 : (indice du) deuxieme argument) 
	 */
	public String getElement(int i){
		return this.comp[i];
	}
	
	/** Methode pour evaluer une comparaison
	 * 
	 * @return la veracite de la comparaison
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
