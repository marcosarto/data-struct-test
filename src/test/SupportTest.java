package test;

import support.MyMenu;

public class SupportTest {

	public static void main(String[] args){
		String[] m = new String[3];
		m[0] = "prova1";
		m[1] = "prova2";
		m[2] = "prova3";
		MyMenu mn = new MyMenu("menu",m);
		mn.stampaMenu();
		System.out.println(mn.scegli());

	}
}
