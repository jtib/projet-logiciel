import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;


public class Notes {
	
	public static Vector<Regle> regles = new Vector<Regle>();
	
	public static void main(String [] args){
		
		//D'abord, les notes de l'eleve
		try(Scanner user_input = new Scanner(System.in)){
			System.out.print("Entrez le nombre d'eleves : ");
			//ajouter exception si mauvais input
			int nb_eleves = Integer.valueOf(user_input.next());
			Fait[] lesFaits = new Fait[nb_eleves];
			for(int j = 0; j < nb_eleves; j++){
				System.out.print("Entrez le nom de l'eleve : ");
				//exception a ajouter
				String nom = user_input.next();
				double[] notes = new double[9];
				System.out.print("Notes de l'eleve\nMathematiques : ");
				notes[0] = Double.valueOf(user_input.next());
				System.out.print("Philosophie : ");
				notes[1] = Double.valueOf(user_input.next());
				System.out.print("Physique - chimie : ");
				notes[2] = Double.valueOf(user_input.next());
				System.out.print("Histoire - Geographie : ");
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
				System.out.print("eleve " + (j+1) + " cree(e)\n");
			}
			
			//Les comparaisons...
			Comparaison comp050 = new Comparaison("all","<",5);
			Comparaison comp051 = new Comparaison("all",">=",5);
			Comparaison comp100 = new Comparaison("all","<",10);
			Comparaison comp101 = new Comparaison("all",">=",10);
			Comparaison comp130 = new Comparaison("all","<",13);
			Comparaison comp131 = new Comparaison("all",">=",13);
			Comparaison comp150 = new Comparaison("all","<",15);
			Comparaison comp151 = new Comparaison("all",">=",15);
			Comparaison comp170 = new Comparaison("all","<",17);
			Comparaison comp171 = new Comparaison("all",">=",17);
			Comparaison comp190 = new Comparaison("all","<=",19);
			Comparaison comp20 = new Comparaison("all","==",20);
			
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
			
			//Pour enfin former les regles
			//ici on les applique toutes a tous les faits donc une boucle suffit
			for(int k=0; k<nb_eleves; k++){
				regles.add(new Regle(lesFaits[k], cond0, 0));
				regles.add(new Regle(lesFaits[k], cond1, 1));
				regles.add(new Regle(lesFaits[k], cond2, 2));
				regles.add(new Regle(lesFaits[k], cond3, 3));
				regles.add(new Regle(lesFaits[k], cond4, 4));
				regles.add(new Regle(lesFaits[k], cond5, 5));
				regles.add(new Regle(lesFaits[k], cond6, 6));
			}
			
			//On utilise la methode de la classe Regle pour obtenir les actions a effectuer
			Hashtable<Integer,Integer> actions = new Hashtable<Integer,Integer>();
			for(Fait f : lesFaits){
				actions = f.aEffectuer(regles);
				System.out.print(f.getName() + " :\n");
				//Et on execute les actions
				Enumeration<Integer> enumKey = actions.keys();
				while(enumKey.hasMoreElements()){
					//Determination de la matiere associee
					int k = enumKey.nextElement();
					String matiere = new String();
					switch(k){
						case 0 : matiere = "Mathematiques";
							break;
						case 1 : matiere = "Philosophie";
							break;
						case 2 : matiere = "Physique - chimie";
							break;
						case 3 : matiere = "Histoire - Geographie";
							break;
						case 4 : matiere = "LV1";
							break;
						case 5 : matiere = "LV2";
							break;
						case 6 : matiere = "ECJS";
							break;
						case 7 : matiere = "EPS";
							break;
						case 8 : matiere = "SVT";
							break;
						default : matiere = "Pipo";
							break;
					}
					
					//Affichage des commentaires
					int v = actions.get(k);
					switch(v){
						case 0 : System.out.print(matiere + " : Mettez-vous au travail !\n");
							break;
						case 1 : System.out.print(matiere + " : Travaillez plus !\n");
							break;
						case 2 : System.out.print(matiere + " : Resultats assez bons mais encore justes. Travaillez et gardez espoir.\n");
							break;
						case 3 : System.out.print(matiere + " : Resultats satisfaisants. Bon travail.\n");
							break;
						case 4 : System.out.print(matiere + " : Tres bons resultats ! Continuez ainsi.\n");
							break;
						case 5 : System.out.print(matiere + " : Excellents resultats !\n");
							break;
						case 6 : System.out.print(matiere + " : Parfait. Rien a redire.\n");
							break;
						default : System.out.print(matiere + " : Plop");
					}
				}
			}
		}
	}
}


