package tree;

public class BinaryTree<T extends Comparable<? super T>> { //perche super?
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
			else leftChild = new BinaryTree<>(child);
		}
		else {
			if (rightChild != null) rightChild.addChild(child);
			else rightChild = new BinaryTree<>(child);
		}
	}

	public void print(){
		System.out.println("Elemento: "+el+" profondita` : "+count);
		count++;

		if(leftChild!=null) {
			leftChild.print();
		}
		if(rightChild!=null) {
			rightChild.print();
		}
	}
}
