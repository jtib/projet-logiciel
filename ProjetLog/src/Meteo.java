//Ne fonctionne pas. Probleme d'ecriture des conditions (pas de sens par rapport a la forme des donnees)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class Meteo {
	
	public static Vector<Regle> regles = new Vector<Regle>();
	
	public static ConditionPrb[] creationConditions(){
		
		ConditionPrb[] cond = new ConditionPrb[32];
		
		//Les comparaisons...
		//Comparaisons sur les temp�ratures
		ComparaisonSimple compn1530 = new ComparaisonSimple("0",">=","-15");
		ComparaisonSimple comp0000 = new ComparaisonSimple("0","<","0");
		ComparaisonSimple comp0030 = new ComparaisonSimple("0",">=","0");
		ComparaisonSimple comp1000 = new ComparaisonSimple("0","<","10");
		ComparaisonSimple comp1030 = new ComparaisonSimple("0",">=","10");
		ComparaisonSimple comp2000 = new ComparaisonSimple("0","<","20");
		ComparaisonSimple comp2030 = new ComparaisonSimple("0",">=","20");
		ComparaisonSimple comp3020 = new ComparaisonSimple("0","<=","30");
		
		//Comparaisons sur le niveau de pr�cipitations
		ComparaisonSimple comp0031 = new ComparaisonSimple("1",">=","0");
		ComparaisonSimple comp4001 = new ComparaisonSimple("1","<","40");
		ComparaisonSimple comp4031 = new ComparaisonSimple("1",">=","40");
		ComparaisonSimple comp10021 = new ComparaisonSimple("1","<=","100");
		
		//Comparaisons sur la vitesse du vent
		ComparaisonSimple comp0032 = new ComparaisonSimple("2",">=","0");
		ComparaisonSimple comp0202 = new ComparaisonSimple("2","<","2");
		ComparaisonSimple comp0232 = new ComparaisonSimple("2",">=","2");
		ComparaisonSimple comp3002 = new ComparaisonSimple("2","<","30");
		ComparaisonSimple comp3032 = new ComparaisonSimple("2",">=","30");
		ComparaisonSimple comp7502 = new ComparaisonSimple("2","<","75");
		ComparaisonSimple comp7532 = new ComparaisonSimple("2",">=","75");
		
		//...que l'on combine dans les conditions
		Comparaison compa00 [] = {compn1530, comp0000, comp0031, comp4001, comp0032, comp0202};
		cond[0] = new ConditionPrb(compa00);
		Comparaison compa01 [] = {compn1530, comp0000, comp0031, comp4001, comp0232, comp3002};
		cond[1] = new ConditionPrb(compa01);
		Comparaison compa02 [] = {compn1530, comp0000, comp0031, comp4001, comp3032, comp7502};
		cond[2] = new ConditionPrb(compa02);
		Comparaison compa03 [] = {compn1530, comp0000, comp0031, comp4001, comp7532};
		cond[3] = new ConditionPrb(compa03);
		Comparaison compa04 [] = {compn1530, comp0000, comp4031, comp10021, comp0032, comp0202};
		cond[4] = new ConditionPrb(compa04);
		Comparaison compa05 [] = {compn1530, comp0000, comp4031, comp10021, comp0232, comp3002};
		cond[5] = new ConditionPrb(compa05);
		Comparaison compa06 [] = {compn1530, comp0000, comp4031, comp10021,  comp3032, comp7502};
		cond[6] = new ConditionPrb(compa06);
		Comparaison compa07 [] = {compn1530, comp0000, comp4031, comp10021, comp7532};
		cond[7] = new ConditionPrb(compa07);

		Comparaison compa08 [] = {comp0030, comp1000, comp0031, comp4001, comp0032, comp0202};
		cond[8] = new ConditionPrb(compa08);
		Comparaison compa09 [] = {comp0030, comp1000, comp0031, comp4001, comp0232, comp3002};
		cond[9] = new ConditionPrb(compa09);
		Comparaison compa10 [] = {comp0030, comp1000, comp0031, comp4001, comp3032, comp7502};
		cond[10] = new ConditionPrb(compa10);
		Comparaison compa11 [] = {comp0030, comp1000, comp0031, comp4001, comp7532};
		cond[11] = new ConditionPrb(compa11);
		Comparaison compa12 [] = {comp0030, comp1000, comp4031, comp10021, comp0032, comp0202};
		cond[12] = new ConditionPrb(compa12);
		Comparaison compa13 [] = {comp0030, comp1000, comp4031, comp10021, comp0232, comp3002};
		cond[13] = new ConditionPrb(compa13);
		Comparaison compa14 [] = {comp0030, comp1000, comp4031, comp10021,  comp3032, comp7502};
		cond[14] = new ConditionPrb(compa14);
		Comparaison compa15 [] = {comp0030, comp1000, comp4031, comp10021, comp7532};
		cond[15] = new ConditionPrb(compa15);

		Comparaison compa16 [] = {comp1030, comp2000, comp0031, comp4001, comp0032, comp0202};
		cond[16] = new ConditionPrb(compa16);
		Comparaison compa17 [] = {comp1030, comp2000, comp0031, comp4001, comp0232, comp3002};
		cond[17] = new ConditionPrb(compa17);
		Comparaison compa18 [] = {comp1030, comp2000, comp0031, comp4001, comp3032, comp7502};
		cond[18] = new ConditionPrb(compa18);
		Comparaison compa19 [] = {comp1030, comp2000, comp0031, comp4001, comp7532};
		cond[19] = new ConditionPrb(compa19);
		Comparaison compa20 [] = {comp1030, comp2000, comp4031, comp10021, comp0032, comp0202};
		cond[20] = new ConditionPrb(compa20);
		Comparaison compa21 [] = {comp1030, comp2000, comp4031, comp10021, comp0232, comp3002};
		cond[21] = new ConditionPrb(compa21);
		Comparaison compa22 [] = {comp1030, comp2000, comp4031, comp10021,  comp3032, comp7502};
		cond[22] = new ConditionPrb(compa22);
		Comparaison compa23 [] = {comp1030, comp2000, comp4031, comp10021, comp7532};
		cond[23] = new ConditionPrb(compa23);

		Comparaison compa24 [] = {comp2030, comp3020, comp0031, comp4001, comp0032, comp0202};
		cond[24] = new ConditionPrb(compa24);
		Comparaison compa25 [] = {comp2030, comp3020, comp0031, comp4001, comp0232, comp3002};
		cond[25] = new ConditionPrb(compa25);
		Comparaison compa26 [] = {comp2030, comp3020, comp0031, comp4001, comp3032, comp7502};
		cond[26] = new ConditionPrb(compa26);
		Comparaison compa27 [] = {comp2030, comp3020, comp0031, comp4001, comp7532};
		cond[27] = new ConditionPrb(compa27);
		Comparaison compa28 [] = {comp2030, comp3020, comp4031, comp10021, comp0032, comp0202};
		cond[28] = new ConditionPrb(compa28);
		Comparaison compa29 [] = {comp2030, comp3020, comp4031, comp10021, comp0232, comp3002};
		cond[29] = new ConditionPrb(compa29);
		Comparaison compa30 [] = {comp2030, comp3020, comp4031, comp10021,  comp3032, comp7502};
		cond[30] = new ConditionPrb(compa30);
		Comparaison compa31 [] = {comp2030, comp3020, comp4031, comp10021, comp7532};
		cond[31] = new ConditionPrb(compa31);

		//ComparaisonDouble compaTest [] = {compTest};
		//ConditionPrb condTest = new ConditionPrb(compaTest);
		
		return cond;
		
	}

	
	public static void main(String [] args){
		
		//D'abord, les conditions (temperature, precipitation et vent) des differents jours
		try(Scanner user_input = new Scanner(System.in)){
			System.out.print("Entrez le nombre de jours : ");
			//ajouter exception si mauvais input
			int nb_jours = Integer.valueOf(user_input.next());
			Fait[] lesFaits = new Fait[nb_jours];
			for(int j = 0; j < nb_jours; j++){
				System.out.print("Entrez le jour en question : ");
				String nom = user_input.next();
				List<Double> temps = new ArrayList<Double>();
				System.out.print("La temperature moyenne (en degres Celsius): ");
				temps.add(Double.valueOf(user_input.next()));
				System.out.print("Niveau des precipitations (en %): ");
				temps.add(Double.valueOf(user_input.next()));
				System.out.print("Vitesse du vent (en km/h) : ");
				temps.add(Double.valueOf(user_input.next()));
				lesFaits[j] = new Fait(nom, temps);
				System.out.print("Le jour " + nom + " est cree\n");
			}
			
			ConditionPrb[] cond = creationConditions();
			

			//Pour enfin former les regles
			for(int k=0; k<nb_jours; k++){
				regles.add(new Regle(lesFaits[k], cond[0], 0));
				regles.add(new Regle(lesFaits[k], cond[1], 1));
				regles.add(new Regle(lesFaits[k], cond[2], 2));
				regles.add(new Regle(lesFaits[k], cond[3], 3));
				regles.add(new Regle(lesFaits[k], cond[4], 4));
				regles.add(new Regle(lesFaits[k], cond[5], 5));
				regles.add(new Regle(lesFaits[k], cond[6], 6));
				regles.add(new Regle(lesFaits[k], cond[7], 7));
				
				regles.add(new Regle(lesFaits[k], cond[8], 8));
				regles.add(new Regle(lesFaits[k], cond[9], 9));
				regles.add(new Regle(lesFaits[k], cond[10], 10));
				regles.add(new Regle(lesFaits[k], cond[11], 11));
				regles.add(new Regle(lesFaits[k], cond[12], 12));
				regles.add(new Regle(lesFaits[k], cond[13], 13));
				regles.add(new Regle(lesFaits[k], cond[14], 14));
				regles.add(new Regle(lesFaits[k], cond[15], 15));
				
				regles.add(new Regle(lesFaits[k], cond[16], 16));
				regles.add(new Regle(lesFaits[k], cond[17], 17));
				regles.add(new Regle(lesFaits[k], cond[18], 18));
				regles.add(new Regle(lesFaits[k], cond[19], 19));
				regles.add(new Regle(lesFaits[k], cond[20], 20));
				regles.add(new Regle(lesFaits[k], cond[21], 21));
				regles.add(new Regle(lesFaits[k], cond[22], 22));
				regles.add(new Regle(lesFaits[k], cond[23], 23));
				
				regles.add(new Regle(lesFaits[k], cond[24], 24));
				regles.add(new Regle(lesFaits[k], cond[25], 25));
				regles.add(new Regle(lesFaits[k], cond[26], 26));
				regles.add(new Regle(lesFaits[k], cond[27], 27));
				regles.add(new Regle(lesFaits[k], cond[28], 28));
				regles.add(new Regle(lesFaits[k], cond[29], 29));
				regles.add(new Regle(lesFaits[k], cond[30], 30));
				regles.add(new Regle(lesFaits[k], cond[31], 31));
			}
			
			//On utilise la methode de la classe Regle pour obtenir les actions a effectuer
			for(Fait f : lesFaits){
				List<Pair<Integer,List<Double>>> actions = new ArrayList<Pair<Integer,List<Double>>>();
				actions = f.aEffectuer(regles);
				System.out.print(f.getName() + " :\n");
				//Et on execute les actions
				for(Pair<Integer,List<Double>> p : actions){

					/*int mat = p.getKey();
					String matiere = new String();
					switch(mat){
					case 0 : matiere = "Le temps";
					break;
					case 1 : matiere = "Le temps";
					break;
					case 2 : matiere = "Le temps";
					break;
					default : matiere = "Pipo";
					break;
					}*/

					//Affichage des commentaires
					List<Double> comList = p.getValue();
					for(double com : comList){
					switch((int)com){
					case 0 : System.out.println(" : Faibles chances d'averses et ciel calme. Attention au gel.");
						break;
					case 1 : System.out.println(" : De jolies brises par un temps sec et glacial.");
						break;
					case 2 : System.out.println(" : Attention aux coups de vent glac�s, combines a des possibilites d'averses isolees.");
						break;
					case 3 : System.out.println(" : Temps glacial. Peu de chance d'averses mais un vent d'ouragan ! Ne pas sortir.");
						break;
					case 4 : System.out.println(" : Temps glacial et calme, mais des averses en vue.");
						break;
					case 5 : System.out.println(" : La poussiere est soulevee par le vent froid. Plusieurs averses.");
						break;
					case 6 : System.out.println(" : Il sera penible d'avancer en grelottant dans le vent et la pluie.");
						break;
					case 7 : System.out.println(" : Ouragan ! Temps glace ! Des averses ! O rage ! O desespoir...");
						break;
					case 8 : System.out.println(" : Froid et sec mais pas glacial. La fumee monte en ligne droite.");
						break;
					case 9 : System.out.println(" : Les branches remuent sous la brise froide, mais le temps n'est pas mouille.");
						break;
					case 10 : System.out.println(" : De petites branches peuvent vous tomber sur la tete, meme si vous avez prevu un bonnet.");
						break;
					case 11 : System.out.println(" : Il fait un peu froid et sec, mais l'ouragan vous interdit de sortir.");
						break;
					case 12 : System.out.println(" : Temps calme, paisible et frais, prevoyez juste un parapluie.");
						break;
					case 13 : System.out.println(" : Des brises fraiches, peut-etre accompagnee par une pluie plus ou moins grande.");
						break;
					case 14 : System.out.println(" : De petites branches mouillees peuvent vous tomber sur la tete et tremper votre chapeau.");
						break;
					case 15 : System.out.println(" : Frais. Des vents violents et une pluie pouvant causer de gros degats.");
						break;
					case 16 : System.out.println(" : Il fait beau, il n'y pas de vent ni de risque de pluie ! Beau temps pour sortir.");
						break;
					case 17 : System.out.println(" : Un beau temps avec une brise legere et douce, ni chaude ni froide. Pourquoi ne pas sortir ?");
						break;
					case 18 : System.out.println(" : Beau temps avec peu de chance de pluie, seulement attention aux pots de fleur qui peuvent tomber.");
						break;
					case 19 : System.out.println(" : Malgre un ciel beau et eclaire, il y a des risques que vous soyez emporte par l'ouragan.");
						break;
					case 20 : System.out.println(" : Pas de vent, il fait doux. Prevoyez juste un parapluie.");
						break;
					case 21 : System.out.println(" : Des risques de pluies soutenus et de faibles brises. Mais il fait doux.");
						break;
					case 22 : System.out.println(" : Doux, humide, beaucoup de vent...il est preferable de bien prendre ses precautions en sortant.");
						break;
					case 23 : System.out.println(" : La temperature est agreable, mais ni l'ouragan ni les averses soutenues encouragent à sortir.");
						break;
					case 24 : System.out.println(" : Pas vraiment de risque de pluie ni de vent, un T-shirt peut etre amplement suffisant comme equipement.");
						break;
					case 25 : System.out.println(" : Un peu de vent, mais vous n'avez pas a prendre votre parapluie, sauf pour se proteger contre les UV.");
						break;
					case 26 : System.out.println(" : Chaud et peu de risque de pluie, mais un vent tres fort...");
						break;
					case 27 : System.out.println(" : Meme s'il fait chaud et beau, vous allez etre emporte par l'ouragan.");
						break;
					case 28 : System.out.println(" : Chaud, humide, des risques de pluie, mais pas une poussiere ne bouge.");
						break;
					case 29 : System.out.println(" : La chaleur et la pluie peuvent etre quelque peu incomfortable, mais vous aurez droit a quelques brises.");
						break;
					case 30 : System.out.println(" : Vous pouvez vous habiller leger pour aujourd'hui. Mais les risques de pluie sont grands et il y a un vent très fort.");
						break;
					case 31 : System.out.println(" : Il fait plutot chaud, mais ce n'est pas vraiment le moment ideal pour sortir...vous seriez la cible de l'ouragan et de l'orage.");
						break;
					default : System.out.print(" : Plop\n");
					}
					}
				}
			}
		}
	}
}


