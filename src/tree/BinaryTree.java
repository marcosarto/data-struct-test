package tree;

public class BinaryTree<T extends Comparable<T>> { //anche Comparable<? super T> volendo
	private BinaryTree<T> leftChild,rightChild;
	private T el;
	private final int depth;

	public BinaryTree(T el) {
		this(el,0);
	}

	public BinaryTree(T el,int depth){
		this.depth = depth;
		this.el = el;
	}

	/**
	 * Il metodo riceve un elemento T, controlla se e` maggiore o minore del padre,
	 * se non ha ancora un figlio (destro o sinistro a seconda che sia maggiore o minore)
	 * modifica il riferimento child da null all'oggetto appena creato contenente il parametro,
	 * nel caso invece il riferimento del figlio sia diverso da null delega il compito al figlio
	 *
	 * @param child elemento da aggiungere all'albero
	 */
	public void addChild(T child){
		if(child.compareTo(el)<0){
			if(leftChild!=null) leftChild.addChild(child);
			else leftChild = new BinaryTree<>(child,(depth+1));
		}
		else {
			if (rightChild != null) rightChild.addChild(child);
			else rightChild = new BinaryTree<>(child,(depth+1));
		}
	}

	/**
	 * Controllo se l'elemento da trovare e` maggiore o minore dell'elemento nel nodo corrente,
	 * se il ramo nel quale dovrei controllare e` null vuol dire che l'albero non contiene
	 * l'elemento da trovare e termino restituendo false, se invece il compareTo restituisce
	 * 0 vuol dire che ho trovato l'elemento cercato
	 *
	 * @param elToFind  elemento da trovare
	 * @return boolean che indica se e` stato trovato o meno
	 */
	public boolean contains(T elToFind){
		if(elToFind.compareTo(el)<0&&leftChild!=null)
			return leftChild.contains(elToFind);
		else if(elToFind.compareTo(el)>0&&rightChild!=null)
			return rightChild.contains(elToFind);
		return elToFind.equals(el);
	}

	public void print(){
		System.out.println("Elemento: "+el+" profondita` : "+depth);

		if(leftChild!=null) {
			leftChild.print();
		}
		if(rightChild!=null) {
			rightChild.print();
		}
	}
}

