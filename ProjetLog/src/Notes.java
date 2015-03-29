import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
//import java.util.Map;
import java.util.Scanner;
//import java.util.Set;
import java.util.Vector;


public class Notes {

	public static Vector<Regle> regles = new Vector<Regle>();

	public static Condition[] creationConditions(){

		//À retourner
		Condition[] cond = new Condition[7];

		//Les comparaisons
		ComparaisonSimple comp050 = new ComparaisonSimple("all","<","5");
		ComparaisonSimple comp051 = new ComparaisonSimple("all",">=","5");
		ComparaisonSimple comp100 = new ComparaisonSimple("all","<","10");
		ComparaisonSimple comp101 = new ComparaisonSimple("all",">=","10");
		ComparaisonSimple comp130 = new ComparaisonSimple("all","<","13");
		ComparaisonSimple comp131 = new ComparaisonSimple("all",">=","13");
		ComparaisonSimple comp150 = new ComparaisonSimple("all","<","15");
		ComparaisonSimple comp151 = new ComparaisonSimple("all",">=","15");
		ComparaisonSimple comp170 = new ComparaisonSimple("all","<","17");
		ComparaisonSimple comp171 = new ComparaisonSimple("all",">=","17");
		ComparaisonSimple comp190 = new ComparaisonSimple("all","<=","19");
		ComparaisonSimple comp20 = new ComparaisonSimple("all","==","20");

		//ComparaisonDouble compTest = new ComparaisonDouble("2", "==", "3");

		//Les conditions
		Comparaison compa0 [] = {comp050};
		cond[0] = new Condition(compa0);
		Comparaison compa1 [] = {comp051, comp100};
		cond[1] = new Condition(compa1);
		Comparaison compa2 [] = {comp101, comp130};
		cond[2] = new Condition(compa2);
		Comparaison compa3 [] = {comp131, comp150};
		cond[3] = new Condition(compa3);
		Comparaison compa4 [] = {comp151, comp170};
		cond[4] = new Condition(compa4);
		Comparaison compa5 [] = {comp171, comp190};
		cond[5] = new Condition(compa5);
		Comparaison compa6 [] = {comp20};
		cond[6] = new Condition(compa6);

		//ComparaisonDouble compaTest [] = {compTest};
		//Condition condTest = new Condition(compaTest);

		return cond;

	}

	public static void main(String [] args){

		//D'abord, les notes de l'eleve
		try(Scanner user_input = new Scanner(System.in)){
			System.out.print("Entrez le nombre d'eleves : ");
			//ajouter exception si mauvais input
			int nb_eleves = Integer.valueOf(user_input.next());
			List<Fait> lesFaits = new ArrayList<Fait>();
			for(int j = 0; j < nb_eleves; j++){
				System.out.print("Entrez le nom de l'eleve : ");
				//exception a ajouter
				String nom = user_input.next();
				List<Double> notes = new ArrayList<Double>();
				System.out.print("Notes de l'eleve\nMathematiques : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("Philosophie : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("Physique - chimie : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("Histoire - Geographie : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("LV1 : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("LV2 : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("ECJS : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("EPS : ");
				notes.add(Double.valueOf(user_input.next()));
				System.out.print("SVT : ");
				notes.add(Double.valueOf(user_input.next()));
				lesFaits.add(new Fait(nom, notes));
				System.out.print("eleve " + (j+1) + " cree(e)\n");
			}


			Condition[] cond = creationConditions();

			//Pour enfin former les regles
			//ici on les applique toutes a tous les faits donc une boucle suffit
			for(int k=0; k<nb_eleves; k++){
				regles.add(new Regle(lesFaits.get(k), cond[0], 0));
				regles.add(new Regle(lesFaits.get(k), cond[1], 1));
				regles.add(new Regle(lesFaits.get(k), cond[2], 2));
				regles.add(new Regle(lesFaits.get(k), cond[3], 3));
				regles.add(new Regle(lesFaits.get(k), cond[4], 4));
				regles.add(new Regle(lesFaits.get(k), cond[5], 5));
				regles.add(new Regle(lesFaits.get(k), cond[6], 6));

				//regles.add(new Regle(lesFaits[k], condTest, 7));
			}
			
			//Regle supplementaire qui ne s'appliquera que sur un nouveau fait de la liste
			List<Double> acts = new ArrayList<Double>();
			acts.add(0.0);
			//Le fait, c'est maths + mettez-vous au travail, i.e. (0,0)
			Fait faitSupplementaire = new Fait("0",acts);
			ComparaisonSimple compSupp = new ComparaisonSimple("all","==","0");
			Comparaison compEnPlus [] = {compSupp};
			Condition condSupp = new Condition(compEnPlus);
			regles.add(new Regle(faitSupplementaire, condSupp,7));

			//On utilise la methode de la classe Fait pour obtenir les actions a effectuer
			for(ListIterator<Fait> iter = lesFaits.listIterator(); iter.hasNext();){
				List<Pair<Integer,List<Double>>> actions = new ArrayList<Pair<Integer,List<Double>>>();
				Fait f = iter.next();
				actions = f.aEffectuer(regles);
				//ajout des nouveaux faits obtenus a la liste de faits actuelle
				for(Pair<Integer,List<Double>> action : actions){
					Fait faitEnPlus = new Fait(String.valueOf(action.getKey()),action.getValue());
					iter.add(faitEnPlus);
				}
			}
			for(Fait f : lesFaits){
				List<Pair<Integer,List<Double>>> actions = new ArrayList<Pair<Integer,List<Double>>>();
				actions = f.aEffectuer(regles);
				System.out.print(f.getName() + " :\n");
				//Et on execute les actions
				for(Pair<Integer,List<Double>> p : actions){
					//Détermination de la matière sujet des actions
					int mat = p.getKey();
					String matiere = new String();
					switch(mat){
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
					List<Double> comList = p.getValue();
					for(double com : comList){
						//cast forcé puisqu'on ne switche que sur des int (sale !)
						switch((int)com){
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
						default : System.out.print(matiere + " : Plop\n");
						}
					}
				}
			}
		}
	}
}


