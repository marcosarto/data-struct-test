package test;


import graph.AdjacenceList;
import shortestPath.Dijkstra;

public class AdjacenceListTest {

	public static void main(String[] args){
		AdjacenceList a = new AdjacenceList(0);
		a.addEdge(0,1,1);
		a.addEdge(0,2,1);
		a.addEdge(0,3,1);
		a.addEdge(1,4,1);
		a.addEdge(2,4,2);
		//syso perche` uguale a sopra
		a.addEdge(2,4,2);
		a.addEdge(3,4,3);
		//syso perche` nodo partenza non trovato
		a.addEdge(99,0,2);


		Dijkstra d = new Dijkstra(a.getAdjacent(),0);
		for(int i:d.retrievePath(4)){
			System.out.println(i);
		}

		//Aggiungi restituzione peso oltre al percorso a ritroso
//		System.out.println(a.toString());
	}
}
