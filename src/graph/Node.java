package graph;

import java.util.Objects;

/**
 * Il nodo rappresenta il peso tra due "interi" del grafo, come intero di partenza viene sottointeso
 * quello che rappresenza la chiave collegata alla linkedList con all'interno i vari nodi
 */
public class Node {
	private int to, weight;

	Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	public int getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	//generato da intellij
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return to == node.to &&
				weight == node.weight;
	}

	//generato da intellij
	@Override
	public int hashCode() {
		return Objects.hash(to, weight);
	}

	@Override
	public String toString() {
		return "" + to;
	}
}
