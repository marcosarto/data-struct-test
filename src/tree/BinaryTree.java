package tree;

public class BinaryTree<T extends Comparable> {
	BinaryTree<T> leftChild,rightChild;
	T el;

	public BinaryTree(T el) {
		this.el = el;
	}

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
		System.out.println("Elemento: "+el);
		if(leftChild!=null) {
			System.out.println("Elementi ramo sinistro: ");
			leftChild.print();
		}
		if(rightChild!=null) {
			System.out.println("Elementi ramo dx: ");
			rightChild.print();
		}
	}
}
