package appreciationsEtudiants;

import java.util.Vector;

public class Arbre<T> {

	private T mot;
	private Vector<Arbre<T>> enfants;

	//Constructeur
	Arbre (T word){
		this.mot = word;
		this.enfants = new Vector<Arbre<T>>();
	}

	//Racine de l'arbre
	public T racine(Arbre<T> arbre){
		return arbre.mot;
	}

	//L'arbre est-il une feuille ?
	public boolean isLeaf(Arbre<T> arbre){
		return arbre.enfants.isEmpty();		
	}

	//nième arbre fils
	public Arbre<T> niemeFils(Arbre<T> arbre, int n){
		if(n >= arbre.enfants.size()){
			return null;
		}
		else{
			return arbre.enfants.get(n);
		}
	}

	//échange deux fils
	public Arbre<T> swapFils(Arbre<T> arbre, int m, int n){
		if(n >= arbre.enfants.size() || m >= arbre.enfants.size()){
			return null;
		}
		else{
			Arbre<T> t = arbre.enfants.get(m);
			arbre.enfants.set(m, arbre.enfants.get(n));
			arbre.enfants.set(n, t);
			return arbre;
		}
	}

	//nombre de feuilles de l'arbre
	public int nfeuilles(Arbre<T> arbre){
		if(isLeaf(arbre)){
			return 1;
		}
		else{
			int sum = 0;
			for(Arbre<T> t : arbre.enfants){
				sum += nfeuilles(t);
			}
			return sum;
		}
	}
	
	//Tous les enfants sont-ils des feuilles ?
	public boolean isLastNode(Arbre<T> arbre){
		boolean b = true;
		int i = 0;
		while(b && i < arbre.enfants.size()){
			b = (isLeaf(arbre.enfants.get(i)));
			i++;
		}
		return b;
	}

	//ajoute une feuille à l'arbre
	public void addFeuille(Arbre<T> arbre, T mot){
		if(isLeaf(arbre) || isLastNode(arbre)){
			Arbre<T> t = new Arbre<T>(mot);
			arbre.enfants.add(t);
		}
		else addFeuille(arbre.enfants.lastElement(), mot);			
		}
		
	}
