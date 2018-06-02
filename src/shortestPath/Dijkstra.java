package shortestPath;

import java.util.*;
import graph.Node;

public class Dijkstra {
	private Map<Integer, LinkedList<Node>> m;
	private int root;
	private List<Double> distance;
	private List<Integer> previous;

	public Dijkstra(Map<Integer, LinkedList<Node>> m, int root) {
		this.m = m;
		this.root = root;
		algDijkstra();
	}

	private void algDijkstra() {
		Set<Integer> toCheck = new HashSet<>();
		distance = new ArrayList<>();
		previous = new ArrayList<>();

		for (Integer i : m.keySet()) {
			distance.set(i, Double.POSITIVE_INFINITY); //err distance size = 0
			previous.set(i, null);
			toCheck.add(i);
		}

		distance.set(root, 0.0);

		do {
			int nodeToExamine = minDist(toCheck);
			toCheck.remove(nodeToExamine);//qui

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

	private int minDist(Set<Integer> toCheck) {
		int index = 0;
		double min = distance.get(0);

		for (Integer i : toCheck) {
			if (Double.compare(min, distance.get(i)) > 0) {
				min = distance.get(i);
				index = i;
			}
		}
		return index;
	}

	public List<Integer> retrivePath(int start, int finish) {
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
	public List<Integer> retrivePath(int finish) {
		return retrivePath(root, finish);
	}
}
