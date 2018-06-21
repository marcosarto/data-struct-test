package test;

import support.InputDati;
import tree.BinaryTree;

public class BinTreeTest {
	public static void main(String[] args){
		BinaryTree<Integer> root = new BinaryTree<>(7);
		for(int i=0;i<6;i++) {
			int t = InputDati.leggiIntero("Inserisci elemento albero : ");
			root.addChild(t);
		}
		root.print();
	}
}
