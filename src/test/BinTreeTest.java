package test;

import tree.BinaryTree;

public class BinTreeTest {
	public static void main(String[] args){
		BinaryTree<Integer> root = new BinaryTree<>(5);
		for(int i=0;i<10;i++){
			root.addChild(i);
		}
		root.print();
	}
}
