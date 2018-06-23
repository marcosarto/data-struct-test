package graph;

import java.util.*;

import graph.Node;

public class Dijkstra {
	private Map<Integer, LinkedList<Node>> m;
	private int root;
	/*
	 * Dato come indice un nodo viene data la distanza dalla root
	 */
	private List<Double> distance;
	/*
	 * Dato come indice un nodo viene dato il nodo precedente da percorrere per arrivare alla
	 * root con il percorso minimo
	 */
	private List<Integer> previous;

	public Dijkstra(Map<Integer, LinkedList<Node>> m, int root) {
		this.m = m;
		this.root = root;
		algDijkstra(); //Calcola i percorsi minimi dei vari nodi alla creazione dell'oggetto
	}

	private void algDijkstra() {
		Set<Integer> toCheck = new HashSet<>();
		distance = new ArrayList<>();
		previous = new ArrayList<>();

		/*
		 * Ogni chiave della mappa viene aggiunta alla lista distance con un valore infinito,
		 * ne viene settato il precedente null (perche` non lo si conosce ancora),
		 * vine aggiunta al set toCheck indicando che non abbiamo ancora controllato quel nodo
		 */
		for (Integer i : m.keySet()) {
			distance.add(i, Double.POSITIVE_INFINITY);
			previous.add(i, null);
			toCheck.add(i);
		}

		distance.set(root, 0.0); //La distanza da percorrere per arrivare alla root e` 0

		do {
			int nodeToExamine = minDist(toCheck);
			toCheck.remove(nodeToExamine);

			for (Node n : m.get(nodeToExamine)) {
				if (!toCheck.contains(n.getTo()))
					continue;
				double new_dist = distance.get(nodeToExamine) + n.getWeight();
				//se new_dist e` minore della distanza gia` conosciuta per arrivare a n
				if (Double.compare(new_dist, distance.get(n.getTo())) < 0) {
					distance.set(n.getTo(), new_dist);
					previous.set(n.getTo(), nodeToExamine);
				}
			}

		} while (!toCheck.isEmpty());
	}

	/**
	 * Cerca il nodo con distanza minima dalla root nel set toCheck
	 *
	 * @param toCheck set contenente i nodi non ancora controllati
	 * @return l'indice del nodo con distanza minima dalla root
	 */
	private int minDist(Set<Integer> toCheck) {
		int index = 0;

		//Controllo che la i venga modificata almeno una volta (non succede se rimangono solo nodi con
		//distanza infinity, forse solo se isolati?)
		boolean iNotChanged = true;
		int lastSetValue = 0; //assume l'ultimo valore del set
		double min = Double.POSITIVE_INFINITY;
		for (Integer i : toCheck) {
			if (Double.compare(min, distance.get(i)) > 0) {
				min = distance.get(i);
				index = i;
				iNotChanged = false;
			}
			lastSetValue = i;
		}
		if (iNotChanged) return lastSetValue;
		return index;
	}

	/**
	 * L'oggetto contiene gia' i percorsi minimi nelle variabili locali, questo metodo
	 * consente di ricevere una lista con i nodi da percorrere
	 *
	 * @param start  nodo di partenza
	 * @param finish nodo di arrivo
	 * @return lista contenente i nodi da percorrere per raggiungere l'arrivo con il percorso minimo
	 */
	public List<Integer> retrievePath(int start, int finish) {
		List<Integer> path = new ArrayList<>();

		path.add(finish); //Setto come punto di partenza l'arrivo (percorso a ritroso)
		int currentNode;
		do {
			currentNode = previous.get(finish);
			path.add(currentNode);
			finish = currentNode;
		} while (currentNode != start);

		return path;
	}

	//overload per sottointendere root come nodo di partenza
	public List<Integer> retrievePath(int finish) {
		return retrievePath(root, finish);
	}
}
