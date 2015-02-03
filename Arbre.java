package appreciationsEtudiants;

import java.util.Vector;

/**
 *Cette classe implémente une structure d'arbre naire.
 *
 *
 *@author Juliette Tibayrenc
 *@version 1.3
 *
 */
public class Arbre<T> {

	private T mot;
	private Arbre<T> parent;
	private Vector<Arbre<T>> enfants;

	/**
	 *Construit un arbre-feuille à partir d'une étiquette
	 *
	 * @param word
	 * 	L'étiquette à partir de laquelle sera construit l'arbre
	 * @return L'arbre créé
	 */
	Arbre (T word){
		this.mot = word;
		this.parent = null;
		this.enfants = new Vector<Arbre<T>>();
	}

	/**
	 * Retourne l'étiquette de la racine d'un arbre
	 *
	 * @return l'étiquette
	 */
	public T racine(){
		return this.mot;
	}

	/**
	 * Permet de déterminer si cet arbre est une feuille
	 *
	 * @return un booléen true ssi cet arbre est une feuille
	 */
	public boolean isLeaf(){
		return this.enfants.isEmpty();		
	}
	
	/**
	 * Permet de déterminer si cet élément est racine de son arbre
	 *
	 * @return un booléen true ssi cet élément est racine
	 */
	public boolean isRoot(){
		return (this.parent == null);
	}

	/**
	 * Permet d'obtenir le nième fils de cet arbre
	 *
	 * @param n
	 * 	Le numéro du fils désiré
	 * @return le fils, qui est un arbre
	 */	
	public Arbre<T> niemeFils(int n){
		if(n >= this.enfants.size()){
			return null;
		}
		else{
			return this.enfants.get(n);
		}
	}

	/**
	 * Permet d'échanger deux fils d'indices donnés
	 *
	 * @param m
	 * 	L'indice du premier fils à échanger
	 * @param n
	 * 	L'indice du deuxième fils à échanger
	 * @return Le nouvel arbre
	 */	
	public Arbre<T> swapFils(int m, int n){
		if(n >= this.enfants.size() || m >= this.enfants.size()){
			return null;
		}
		else{
			Arbre<T> tm = this.enfants.get(m);
			Arbre<T> parentM = tm.parent;
			Arbre<T> parentN = this.enfants.get(n).parent;
			this.enfants.set(m, this.enfants.get(n));
			this.enfants.get(m).parent = parentM;
			this.enfants.set(n, tm);
			this.enfants.get(n).parent = parentN;
			return this;
		}
	}

	/**
	 * Retourne le nombre de feuilles de cet arbre
	 *
	 * @return le nombre de feuilles
	 */
	public int nfeuilles(){
		if(this.isLeaf()){
			return 1;
		}
		else{
			int sum = 0;
			for(Arbre<T> t : this.enfants){
				sum += t.nfeuilles();
			}
			return sum;
		}
	}
	
	/**
	 * Permet de savoir si l'élément concerné n'a que des feuilles pour enfants
	 *
	 * @return le booléen correspondant
	 */
	public boolean isLastNode(){
		boolean b = true;
		int i = 0;
		while(b && i < this.enfants.size()){
			b = (this.enfants.get(i).isLeaf());
			i++;
		}
		return b;
	}

	/**
	 * Ajoute une feuille à cet arbre
	 *
	 * @param mot
	 * 	L'étiquette de cette future nouvelle feuille
	 * @return le nouvel arbre
	 */
	public Arbre<T> addFeuille(T mot){
		Arbre<T> t = new Arbre<T>(mot);
		t.parent = this;
		this.enfants.add(t);
		return this;
	}
}
