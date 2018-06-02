package graph;

public class Node {
	int to, weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	public int getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "" + to;
	}
}
