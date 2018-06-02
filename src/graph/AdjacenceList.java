package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class AdjacenceList {
	Map<Integer, LinkedList<Node>> adjacent;

	public AdjacenceList(int root) {
		adjacent = new HashMap<>();
		adjacent.put(root, new LinkedList<>());
	}

	public void addEdge(int from,int to,int weight){
		adjacent.get(from).add(new Node(to,weight));
		if(!adjacent.containsKey(to))
			adjacent.put(to,new LinkedList<>());
	}

	public void addEdge(int from,int to){
		addEdge(from,to,1);
	}

	public Map<Integer, LinkedList<Node>> getAdjacent() {
		return adjacent;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer,LinkedList<Node>> entry : adjacent.entrySet()){
			sb.append(entry.getKey());
			sb.append("\n");
			for(Node n : entry.getValue()){
				sb.append(n.toString()+" ");
			}
			sb.append("\n");

		}
		return sb.toString();
	}
}
