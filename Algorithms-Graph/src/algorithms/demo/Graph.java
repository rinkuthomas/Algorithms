package algorithms.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	private int numOfNodes;
	private LinkedList<Integer> graph[]; // using adjacency lists
	boolean[] visitedDfs = new boolean[numOfNodes];
    LinkedList<Integer> stack = new LinkedList<>();
    

	public Graph(int numOfNodes) {
		this.numOfNodes = numOfNodes;
		graph = new LinkedList[numOfNodes];
		for (int i = 0; i < numOfNodes; i++) {
			graph[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int node, int nextNode) {
		graph[node].add(nextNode);

	}
	public void testDfs(int startingNode) {
		visitedDfs = new boolean[numOfNodes];
		dfs(startingNode, visitedDfs, stack);
		
		//Printing out the DFS
        Iterator<Integer> iter = stack.iterator();
        System.out.println("Printing out the DFS graph: ");
        while(iter.hasNext()) {
        	System.out.println(iter.next());
        
        }
        stack.clear();
	}
	
	public void dfs(int startingNode, boolean[] visitedDfs, LinkedList<Integer> stack) {
		
		visitedDfs[startingNode] = true;
		System.out.println("Processing node :" + startingNode);
		
		
		LinkedList<Integer> neighbors = graph[startingNode];
		
		Iterator<Integer> iter = neighbors.iterator();
		
		while(iter.hasNext()) {
			int nextNode = iter.next();
			if(!visitedDfs[nextNode]) {
				visitedDfs[nextNode] = true;
				dfs(nextNode, visitedDfs, stack);
			}
			
			
		}
		stack.push(startingNode);

	}

	public void bfs(int startingNode) {

		boolean[] visited = new boolean[numOfNodes];

		visited[startingNode] = true;
		System.out.println("The Starting node is :" + startingNode);

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(startingNode);

		while (!queue.isEmpty()) {
			Integer nextNode = queue.poll();
			System.out.println("Traversing node : " + nextNode);

			Iterator<Integer> iter = graph[nextNode].iterator();
			while (iter.hasNext()) {
				nextNode = iter.next();
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					queue.add(nextNode);
				}
			}

		}
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(12);
		g.addEdge(5,3);
        g.addEdge(5, 8);
        g.addEdge(3, 7);
        g.addEdge(3, 6);
        g.addEdge(8, 9);
        g.addEdge(8, 11);
        
        System.out.println("The graph is :" );
        g.printGraph();
        
        //Testing BFS
        System.out.println("The BFS representations is :" );
        g.bfs(5);
		g.bfs(8);
		
		//Testing DFS
		System.out.println("The nonStack DFS representation of the graph is :" );
        g.testDfs(5);
		g.testDfs(8);
		
		System.out.println("The stack DFS representation is : ");
		g.dfsWithStack(5);
				                                    
	}

	private void dfsWithStack(int start) {
		
		LinkedList<Integer> stack = new LinkedList<>();
		boolean[] visited = new boolean[numOfNodes];
		
		visited[start] = true;
		System.out.println("This is teh DFS with stack traversal!!");
		System.out.println("Start node is:" + start);
		
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			System.out.println("Traversing node " + node);
			LinkedList<Integer> neighbors = graph[node];
			Iterator<Integer> iter = neighbors.iterator();
			while (iter.hasNext()) {
				node = iter.next();
				if (!visited[node]) {
					visited[node] = true;
					stack.push(node);

				}
			}
			
		}
		
	}

	private void printGraph() {
		for(int i=0; i< numOfNodes; i++) {
			System.out.print("NOde " + i + " is connected to: ");
			System.out.println(graph[i]);
			
			
		}
	}

}
