
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
	
	
	
	public String getElement(int i){
		return this.comp[i];
	}
	
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
