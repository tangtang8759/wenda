package sort;

import java.util.*;

class Node {
    List<Node> neighbors;
    int label;
    Node(int label) {
        neighbors = new ArrayList<>();
        this.label = label;
    }
}

public class Exercise {
    public Node cloneGraph(Node node, HashMap<Integer, Node> hashmap) {
    	
    	int label = node.label;
    	List<Node> neighbors = node.neighbors;
    	
    	Node cloneNode = new Node(label);
    	cloneNode.neighbors = new ArrayList<Node>();
    	
    	hashmap.put(cloneNode.label, cloneNode);
    	
    	Node coloneNeighbor=null;
    	for(Node neighbor: neighbors) {
    		coloneNeighbor = hashmap.get(neighbor.label);
    		if(coloneNeighbor==null) {
    			coloneNeighbor = cloneGraph(neighbor, hashmap);
    		}
    		cloneNode.neighbors.add(coloneNeighbor);
    	}
    	
    	return cloneNode;
    }
    public Node cloneGraph(Node node) {
    	HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
    	return cloneGraph(node, hashmap);
    }
}