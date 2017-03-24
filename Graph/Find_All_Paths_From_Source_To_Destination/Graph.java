package pocketGems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	public HashMap<String, LinkedList<String>> g = new HashMap<>();	
	
	private Stack<String> path  = new Stack<String>();
	private LinkedList<String> current = new LinkedList<>();
	
    public void printAllPaths(String s, String t) {
        DFS(s, t);
    }
    
    private void DFS(String v, String t) {

        path.push(v);
        current.add(v);

        if (v.equals(t) && this.g.size() > 0) 
            System.out.println(path);

        else if (this.g.containsKey(v)){
        	for (String v2 : this.g.get(v)) {
                if (!current.contains(v2)) {
                	DFS(v2, t);
                }
            }
        }

        path.pop();
        current.remove(v);
    }

	public void addEdges(String v, String v2)
	{
		LinkedList<String> temp = new LinkedList<>();
		if(g.containsKey(v)) {
			temp = g.get(v);
		}
		temp.add(v2);
		this.g.put(v, temp);		
	}
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdges("A", "B");
		graph.addEdges("A", "C");
		graph.addEdges("B", "C");
		graph.addEdges("A", "D");
		graph.addEdges("B", "B");
		graph.addEdges("B", "E");
		graph.addEdges("E", "C");
		graph.addEdges("D", "C");
		System.out.println("All paths from A to C are :");
		graph.printAllPaths("A", "C");
	}

}
