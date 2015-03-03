import java.util.Vector;


public class Notes {
	
	public static Regle[] regles = new Regle[1];
	
	public static void main(String [] args){
		double notes [] = {18,13}; 
		Fait fait1 = new Fait("Eve", notes);
		Fait lesFaits [] = {fait1};
		Comparaison comp1 = new Comparaison(0,20,"<");
		Comparaison comp2 = new Comparaison(1,12,">=");
		Comparaison compa [] = {comp1,comp2};
		Condition cond1 = new Condition(compa,fait1);
		regles[0] = new Regle(fait1, cond1, 0);
		Vector<Integer> actions = regles[0].aEffectuer(regles, lesFaits);
		int i = actions.firstElement();
		if(i==0){
			System.out.print("C'est pas mal tout ça");
		}
	}
}
