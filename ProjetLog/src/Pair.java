
public class Pair<K,V> {

	private K key;
	private V value;

	/**
	 * Constructeur
	 * @param k : la cle de la paire
	 * @param v : la valeur associee
	 */
	public Pair(K k, V v) {
		this.key = k;
		this.value = v;
	}

	/**
	 * 
	 * @return la cle de la paire
	 */
	public K getKey(){
		return this.key;
	}

	/**
	 * 
	 * @return la valeur de la paire
	 */
	public V getValue(){
		return this.value;
	} 

}
