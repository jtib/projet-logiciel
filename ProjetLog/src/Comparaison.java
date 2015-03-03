
public class Comparaison extends Predicat {
	
	String[] comp;//ce type est-il vraiment nécessaire ?

	public Comparaison(int a, double b, String op){
		this.comp = new String[3];
		comp[0] = String.valueOf(a);
		comp[1] = op;
		comp[2] = String.valueOf(b);
	}
}
