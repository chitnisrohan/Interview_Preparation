package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_207 {
	
	private boolean result = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, GraphNode> hashMap = new HashMap<>();
        HashMap<GraphNode, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0 ; i < numCourses ; i++) {
            hashMap.put(i, new GraphNode(i));
            graph.put(hashMap.get(i), new LinkedList<>());
        }
        for (int i = 0 ; i < prerequisites.length ; i++) {
            List<GraphNode> list = graph.get(hashMap.get(prerequisites[i][0]));
            list.add(hashMap.get(prerequisites[i][1]));
            graph.put(hashMap.get(prerequisites[i][0]), list);
        }
        this.result = true;
        DFS(graph);        
        return this.result;
    }
    
    private void DFS(HashMap<GraphNode, List<GraphNode>> graph) {
        for (GraphNode g : graph.keySet()) {
            if (g.getColor() == 0) {
                DFS_VISIT(graph, g);
            } 
        }
    }
    
    private void DFS_VISIT(HashMap<GraphNode, List<GraphNode>> graph, GraphNode u) {
        u.setColor(1);
        for (GraphNode v : graph.get(u)) {
            if (v.getColor() == 1) {
                this.result = false;
                break;
            }                
            if (v.getColor() == 0) {
                v.setParent(u);
                DFS_VISIT(graph, v);
            }
        }
        u.setColor(2);
    }
    
}

class GraphNode {
	private int node;
	private GraphNode parent;
	private int color;
    
    public GraphNode(int node) {
		this.node = node;
	}
    
   	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	
	public GraphNode getParent() {
		return parent;
	}
	public void setParent(GraphNode parent) {
		this.parent = parent;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

}
