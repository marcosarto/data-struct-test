package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Per mantenere la struttura ricorsiva esplicita immagino l'albero composto da piu classi TreeNode
 * ognuna delle quali raffigura un nodo e i suoi figli
 */

public class TreeNode<T>{
	private T data; //Data di questo TreeNode
	private List<TreeNode> tChildrens = new ArrayList<>(); //O linkedList
	private TreeNode parent = null; //Root avra` genitore null

	public TreeNode(T data) {
		this.data = data;
	}

	public void addChild(TreeNode<T> tree){
		tree.setParent(this);
		tChildrens.add(tree);
	}

	public void addChild(T data){
		TreeNode<T> toAdd = new TreeNode<>(data);
		toAdd.setParent(this);
		tChildrens.add(toAdd);
	}

	public void setParent(TreeNode<T> parent){
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	//Da rivedere se diverso da String int o simili
	public void print(){
		System.out.println("Data : "+data);
		String parentData = parent!=null ? (String)parent.getData() : "null";
		System.out.println("Parent : "+parentData);
		System.out.println("-----------------");
		for(TreeNode t : tChildrens){
			t.print();
		}
	}
}
