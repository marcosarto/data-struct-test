package tree;

public class BinaryTree<T extends Comparable> {
	BinaryTree<T> leftChild,rightChild;
	T el;

	public BinaryTree(T el) {
		this.el = el;
	}

	public void addChild(BinaryTree<T> child){
		if(child.getEl().compareTo(el)<0) leftChild=child;
		else rightChild = child;
	}

	public T getEl() {
		return el;
	}

	public String toString(){
		String msg;
		msg = "Il padre e`: "+el+" il figlio destro e`: "+rightChild+" il figlio sinistro e`: "+leftChild;
		return msg;
	}
}
