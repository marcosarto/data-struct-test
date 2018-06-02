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
		a.addEdge(3,4,3);


		Dijkstra d = new Dijkstra(a.getAdjacent(),0);
		for(int i:d.retrievePath(4)){
			System.out.println(i);
		}

//		a.addEdge(4,1);
		/*Manca controllo del parametro from
		//cosa succede se metto due volte lo stesso collegamento (addEdge)
		Aggiungi restituzione peso oltre al percorso a ritroso
		 */
//		System.out.println(a.toString());
	}
}
