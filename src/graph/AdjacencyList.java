package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implementazione di grafico con metodo dell'adjacence list
 */
public class AdjacencyList {
	private Map<Integer, LinkedList<Node>> adjacent;

	/**
	 * Crea una nuova hashmap e collega al nodo root una nuova linkedlist
	 *
	 * @param root Indica (con un intero) il nodo che verra` usato come partenza
	 */
	public AdjacencyList(int root) {
		adjacent = new HashMap<>();
		adjacent.put(root, new LinkedList<>());
	}

	/**
	 * Aggiunge un collegamento alla mappa con peso
	 *
	 * @param from   Nodo di partenza
	 * @param to     Nodo di arrivo
	 * @param weight Peso del collegamento tra i due nodi
	 */
	public void addEdge(int from, int to, int weight) {
		if (adjacent.containsKey(from)) { //Controlla se il nodo di partenza e` nella mappa

			Node n = new Node(to, weight);

			//Controllo che non sia gia` presente un percorso tra questi due nodi
			if (!adjacent.get(from).contains(n))
				adjacent.get(from).add(n);
			else
				System.out.printf("E` gia` stato specificato un percorso tra %s e %s\n", from, to);

			//Se e` la prima volta che aggiungo un certo nodo come destinazione predispongo
			//una linkedlist nella mappa per eventuali suoi(del nuovo nodo 'to') collegamenti
			if (!adjacent.containsKey(to))
				adjacent.put(to, new LinkedList<>());
		} else
			System.out.printf("Il nodo di partenza %s non e` presente nel grafo\n", from);
	}

	public void addEdge(int from, int to) {
		addEdge(from, to, 1);
	}

	public Map<Integer, LinkedList<Node>> getAdjacent() {
		return adjacent;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, LinkedList<Node>> entry : adjacent.entrySet()) {
			sb.append(entry.getKey());
			sb.append("\n");
			for (Node n : entry.getValue()) {
				sb.append(n.toString() + " ");
			}
			sb.append("\n");

		}
		return sb.toString();
	}
}
