package appreciationsEtudiants;

import java.util.Vector;

public class Arbre<T> {

	private T mot;
	private Arbre<T> parent;
	private Vector<Arbre<T>> enfants;

	//Constructeur pour un arbre-feuille
	Arbre (T word){
		this.mot = word;
		this.parent = null;
		this.enfants = new Vector<Arbre<T>>();
	}

	//Etiquette de la racine de l'arbre
	public T racine(){
		return this.mot;
	}

	//L'arbre est-il une feuille ?
	public boolean isLeaf(){
		return this.enfants.isEmpty();		
	}
	
	//L'élément est-il racine de l'arbre ?
	public boolean isRoot(){
		return (this.parent == null);
	}

	//nième arbre fils
	public Arbre<T> niemeFils(int n){
		if(n >= this.enfants.size()){
			return null;
		}
		else{
			return this.enfants.get(n);
		}
	}

	//échange deux fils
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

	//nombre de feuilles de l'arbre
	public int nfeuilles(){
		if(this.isLeaf()){
			return 1;
		}
		else{
			int sum = 0;
			for(Arbre<T> t : arbre.enfants){
				sum += t.nfeuilles();
			}
			return sum;
		}
	}
	
	//Tous les enfants sont-ils des feuilles ?
	public boolean isLastNode(){
		boolean b = true;
		int i = 0;
		while(b && i < this.enfants.size()){
			b = (isLeaf(this.enfants.get(i)));
			i++;
		}
		return b;
	}

	//ajoute une feuille à l'arbre
	public void addFeuille(T mot){
		Arbre<T> t = new Arbre<T>(mot);
		t.parent = this;
		this.enfants.add(t);
	}
}
