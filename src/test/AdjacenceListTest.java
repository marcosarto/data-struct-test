package test;


import graph.AdjacenceList;
import shortestPath.Dijkstra;

public class AdjacenceListTest {

	public static void main(String[] args){
		AdjacenceList a = new AdjacenceList(0);
		a.addEdge(0,2);
		a.addEdge(0,1);
		a.addEdge(1,2);
		a.addEdge(1,0);
		a.addEdge(2,3);
		a.addEdge(3,1);

		Dijkstra d = new Dijkstra(a.getAdjacent(),0);
		for(int i:d.retrivePath(3)){
			System.out.println(i);
		}

//		a.addEdge(4,1);
		/*Manca controllo del parametro from
		* Si potrebbero mettere i pesi*/
		System.out.println(a.toString());
	}
}
