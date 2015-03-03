
public class Comparaison {
	
	private String[] comp;
	
	public Comparaison(String op, double b){
		this.comp = new String[3];
		comp[1] = op;
		comp[2] = String.valueOf(b);
	}
	
	/** MŽthode pour modifier le premier terme de la comparaison
	 * 
	 * @param a La nouvelle valeur du premier terme 
	 */
	public void setFirstArg(double a){
		this.comp[0] = String.valueOf(a);
	}
	
	public double getElement(int i){
		return Double.valueOf(this.comp[i]);
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
			default: bool = true;
				break;
		}
		return bool;
	}
}
