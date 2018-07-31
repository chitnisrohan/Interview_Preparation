package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII_210 {
	
	class GraphNode {
		private int node;
		private GraphNode parent;
		private int color;
	    private int f;
	    
	    public GraphNode(int node) {
			this.node = node;
		}
	    
	    public int getF() {
			return f;
		}
		public void setF(int f) {
			this.f = f;
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

	
	private boolean result = true;
    private int time;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.time = 0;
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
        int[] output = new int[numCourses];
        for (Integer i : hashMap.keySet()) {
            output[hashMap.get(i).getF()] = i;
        }
        if (result == false)
            return new int[0];
        return output;
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
        u.setF(this.time++);
    }
}

