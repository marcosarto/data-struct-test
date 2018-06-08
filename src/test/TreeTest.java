package test;

import tree.*;

public class TreeTest {
	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<>("Primo");
		TreeNode<String> secondo1 = new TreeNode<>("Secondo1");
		TreeNode<String> secondo2 = new TreeNode<>("Secondo2");

		secondo1.addChild("Secondo11");
		secondo1.addChild("Secondo12");
		root.addChild(secondo1);
		root.print();
	}
}
