import java.util.Scanner;
import java.util.Vector;


public class Notes {
	
	public static Vector<Regle> regles = new Vector<Regle>();
	
	
	/*public static void main(String [] args){
	 double notes1 [] = {18,13};
	 Fait fait1 = new Fait("Eve", notes1);
	 Fait lesFaits [] = {fait1};
	 Comparaison comp1 = new Comparaison(0, "<", 20);
	 Comparaison comp2 = new Comparaison(1, ">=", 12);
	 Comparaison compa [] = {comp1,comp2};
	 Condition cond1 = new Condition(compa);
	 regles[0] = new Regle(fait1, cond1, 0);
	 Vector<Integer> actions = regles[0].aEffectuer(regles, lesFaits);
	 int i = actions.firstElement();
	 if(i==0){
	 System.out.print("C'est pas mal tout ça");
	 }
	 }*/
	
	public static void main(String [] args){
		
		//D'abord, les notes de l'élève
		Scanner user_input = new Scanner(System.in);
		System.out.print("Entrez le nombre d'élèves : ");
		//ajouter exception si mauvais input
		int nb_eleves = Integer.valueOf(user_input.next());
		Fait[] lesFaits = new Fait[nb_eleves];
		for(int j = 0; j < nb_eleves; j++){
			System.out.print("Entrez le nom de l'élève : ");
			//exception à ajouter
			String nom = user_input.next();
			double[] notes = new double[9];
			System.out.print("Notes de l'élève\n Mathématiques : ");
			notes[0] = Double.valueOf(user_input.next());
			System.out.print("Philosophie : ");
			notes[1] = Double.valueOf(user_input.next());
			System.out.print("Physique - chimie : ");
			notes[2] = Double.valueOf(user_input.next());
			System.out.print("Histoire - Géographie : ");
			notes[3] = Double.valueOf(user_input.next());
			System.out.print("LV1 : ");
			notes[4] = Double.valueOf(user_input.next());
			System.out.print("LV2 : ");
			notes[5] = Double.valueOf(user_input.next());
			System.out.print("ECJS : ");
			notes[6] = Double.valueOf(user_input.next());
			System.out.print("EPS : ");
			notes[7] = Double.valueOf(user_input.next());
			System.out.print("SVT : ");
			notes[8] = Double.valueOf(user_input.next());
			lesFaits[j] = new Fait(nom, notes);
			System.out.print("Élève " + (j+1) + " créé(e)\n");
		}
		
		//Les comparaisons...
		Comparaison comp050 = new Comparaison("<",5);
		Comparaison comp051 = new Comparaison(">=",5);
		Comparaison comp100 = new Comparaison("<",10);
		Comparaison comp101 = new Comparaison(">=",10);
		Comparaison comp130 = new Comparaison("<",13);
		Comparaison comp131 = new Comparaison(">=",13);
		Comparaison comp150 = new Comparaison("<",15);
		Comparaison comp151 = new Comparaison(">=",15);
		Comparaison comp170 = new Comparaison("<",17);
		Comparaison comp171 = new Comparaison(">=",17);
		Comparaison comp190 = new Comparaison("<=",19);
		Comparaison comp20 = new Comparaison("==",20);
		
		//...que l'on combine dans les conditions
		Comparaison compa0 [] = {comp050};
		Condition cond0 = new Condition(compa0);
		Comparaison compa1 [] = {comp051, comp100};
		Condition cond1 = new Condition(compa1);
		Comparaison compa2 [] = {comp101, comp130};
		Condition cond2 = new Condition(compa2);
		Comparaison compa3 [] = {comp131, comp150};
		Condition cond3 = new Condition(compa3);
		Comparaison compa4 [] = {comp151, comp170};
		Condition cond4 = new Condition(compa4);
		Comparaison compa5 [] = {comp171, comp190};
		Condition cond5 = new Condition(compa5);
		Comparaison compa6 [] = {comp20};
		Condition cond6 = new Condition(compa6);
		
		//Pour enfin former les règles
		//ici on les applique toutes à tous les faits donc une boucle suffit
		for(int k=0; k<nb_eleves; k++){
			regles.add(new Regle(lesFaits[k], cond0, 0));
			regles.add(new Regle(lesFaits[k], cond1, 1));
			regles.add(new Regle(lesFaits[k], cond2, 2));
			regles.add(new Regle(lesFaits[k], cond3, 3));
			regles.add(new Regle(lesFaits[k], cond4, 4));
			regles.add(new Regle(lesFaits[k], cond5, 5));
			regles.add(new Regle(lesFaits[k], cond6, 6));
		}
		
		//On utilise la méthode de la classe Regle pour obtenir les actions à effectuer
		Vector<Integer> actions = new Vector<Integer>();
		for(Regle r : regles){
			actions = r.aEffectuer(lesFaits);
			System.out.print("Actions générées\n");
			//Et on exécute les actions
			for(int a : actions){
				switch(a){
					case 0 : System.out.print("Mettez-vous au travail !\n");
						break;
					case 1 : System.out.print("Travaillez plus !\n");
						break;
					case 2 : System.out.print("Résultats assez biens mais encore justes. Travaillez et gardez espoir.\n");
						break;
					case 3 : System.out.print("Résultats satisfaisants. Bon travail.\n");
						break;
					case 4 : System.out.print("Très bons résultats ! Continuez ainsi.\n");
						break;
					case 5 : System.out.print("Excellents résultats !\n");
						break;
					case 6 : System.out.print("Parfait. Rien à redire.\n");
						break;
					default : System.out.print("Plop");
				}
			}
		}
	}
}


