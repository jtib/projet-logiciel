import java.util.ArrayList;
import java.util.List;


public class Deductions {

	public static List<Regle> regles = new ArrayList<Regle>();
	public static List<Fait> faits = new ArrayList<Fait>();

	public static void ajoutRegle0(){
		//Creation d'une comparaison
		Comparaison comp = new ComparaisonDouble("0","<","1");

		//Creation d'une condition
		Comparaison[] tabComp = {comp};
		Condition cond = new Condition(tabComp);

		//Creation d'un fait
		List<Double> donnees = new ArrayList<Double>();
		donnees.add(3.0);
		donnees.add(5.0);
		donnees.add(7.0);
		Fait faitPlop = new Fait("plop",donnees);

		//Creation d'une regle
		Regle regle0 = new Regle(faitPlop,cond,0);

		//Ajout au vecteur de regles
		regles.add(regle0);
	}

	public static void ajoutRegle1(){
		//Creation d'une comparaison
		Comparaison comp = new ComparaisonSimple("0","<","15");

		//Creation d'une condition
		Comparaison[] tabComp = {comp};
		Condition cond = new Condition(tabComp);

		//Creation d'un fait
		List<Double> donnees = new ArrayList<Double>();
		donnees.add(3.0);
		donnees.add(5.0);
		donnees.add(7.0);
		//Creation d'une deuxieme regle
		Fait faitPlopiplop = new Fait("plopiplop", donnees);
		Regle regle1 = new Regle(faitPlopiplop,cond,1);

		//ajout au vecteur de regles
		regles.add(regle1);
	}

	public static void main(String [] args){

		ajoutRegle0();
		ajoutRegle1();
		System.out.print("Regles creees\n");

		//Creation (en vrai cette fois) du fait 0
		List<Double> donnees = new ArrayList<Double>();
		donnees.add(3.0);
		donnees.add(5.0);
		donnees.add(7.0);
		Fait fait0 = new Fait("plop",donnees);

		//ajout du fait 0 aux faits
		faits.add(fait0);
		System.out.print("Fait 0 cree et ajoute\n");

		//Application des regles aux faits existants
		//La premiere doit s'appliquer tout de suite, la deuxieme doit s'appliquer au fait genere par la premiere
		//Probleme : en Java, on ne doit pas ajouter d'element a ce sur quoi on est en train d'iterer (comportement imprevisible d'apres la doc)
		//on cree donc une deuxieme liste dans laquelle on met les faits actuels et les nouveaux generes, sur laquelle on iterera ensuite

		List<Fait> faitsTotaux = new ArrayList<Fait>();

		for(Fait f : faits){
			List<Pair<Integer,List<Double>>> actions = new ArrayList<Pair<Integer,List<Double>>>();
			actions = f.aEffectuer(regles);
			for(Pair<Integer,List<Double>> action : actions){
				List<Double> aFaire = action.getValue();
				for(double actionAFaire : aFaire){
					switch((int)actionAFaire){
					//Si la premiere regle s'applique, on ajoute un deuxieme fait
					case 0 :
						//On ajoute le fait sur lequel on travaille a la liste faitsTotaux
						faitsTotaux.add(f);
						//On ajoute le fait supplementaire
						Fait faitEnPlus = new Fait("plopiplop",action.getValue());
						faitsTotaux.add(faitEnPlus);
						System.out.print("Premier et deuxieme fait ajoutes a la seconde liste\n");
						break;
					//Si elle ne s'applique pas, on affiche 42
					default :
						System.out.print("42\n");
						break;
					}
				}
			}
		}
		
		for(Fait f : faitsTotaux){
			List<Pair<Integer,List<Double>>> actions = new ArrayList<Pair<Integer,List<Double>>>();
			actions = f.aEffectuer(regles);
			for(Pair<Integer,List<Double>> action : actions){
				List<Double> aFaire = action.getValue();
				for(double actionAFaire : aFaire){
					switch((int)actionAFaire){
					//Si la deuxieme regle s'applique, on affiche "Done"
					case 1 :
						System.out.print("Done\n");
						break;
					//Si la deuxieme regle ne s'applique pas, on affiche 43
					default :
						System.out.print("La deuxieme regle ne s'applique pas sur le fait actuel de la seconde liste (c'est-a-dire le premier fait, de nom plop)\n");
						break;
					}
				}
			}
		}
	}
}
