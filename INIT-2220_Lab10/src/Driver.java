
public class Driver {
	public static void main(String[] args) {
		DirectedGraph<String> directedGraph = new DirectedGraph<>();
		//ADDING VERTICIES
		directedGraph.addVertex("A");
		directedGraph.addVertex("B");
		directedGraph.addVertex("C");
		directedGraph.addVertex("D");
		directedGraph.addVertex("E");
		directedGraph.addVertex("F");
		directedGraph.addVertex("G");
		directedGraph.addVertex("H");
		directedGraph.addVertex("I");
		directedGraph.addVertex("J");
		directedGraph.addVertex("K");
		directedGraph.addVertex("L");
		directedGraph.addVertex("M");

		//ADDING EDGES
		directedGraph.addEdge("A","B",5);
		directedGraph.addEdge("B","C",1);
		directedGraph.addEdge("C","D",3);
		directedGraph.addEdge("D","E",4);
		directedGraph.addEdge("F","B",2);
		directedGraph.addEdge("F","I",12);
		directedGraph.addEdge("B","G",4);
		directedGraph.addEdge("E","G",4);
		directedGraph.addEdge("J","G",3);
		directedGraph.addEdge("J","K",2);
		directedGraph.addEdge("K","H",4);
		directedGraph.addEdge("H","G",3);
		directedGraph.addEdge("G","I",1);
		directedGraph.addEdge("L","J",1);
		directedGraph.addEdge("M","L",7);
		
		//BREADTH
		System.out.println("Breadth First Traversal: ");
		QueueInterface<String> directedLine = directedGraph.getBreadthFirstTraversal("A");
		while(!directedLine.isEmpty()) {
			System.out.println(directedLine.dequeue());
		}
		
		//DEPTH
		System.out.println("Depth First Traversal: ");
		QueueInterface<String> directedLine2 = directedGraph.getDepthFirstTraversal("A");
		while(!directedLine2.isEmpty()) {
			System.out.println(directedLine2.dequeue());
		}
			
		//TOPOLOGICAL
		System.out.println("Topological Sort: ");
		try {
			StackInterface<String> directedStack = directedGraph.getTopologicalOrder();
			while(!directedStack.isEmpty()) {
				System.out.println(directedStack.pop());
			}
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		//CHEAPEST PATH
		System.out.println("Cheapest Path: ");
		StackInterface<String> directedPath = new LinkedStack<>();
		System.out.println(directedGraph.getCheapestPath("F", "M", directedPath));
		while(!directedPath.isEmpty())
			System.out.println(directedPath.pop());
		System.out.println("----------------------------------------------");
		UndirectedGraph<String> undirectedGraph = new UndirectedGraph<>();
		//ADDING VERTICIES
		
		undirectedGraph.addVertex("LAX");
		undirectedGraph.addVertex("PHX");
		undirectedGraph.addVertex("LAS");
		undirectedGraph.addVertex("IAH");
		undirectedGraph.addVertex("DEN");
		undirectedGraph.addVertex("ORD");
		undirectedGraph.addVertex("DCA");
		undirectedGraph.addVertex("DFW");
		undirectedGraph.addVertex("MSP");
		
		//ADDING EDGES
		
		undirectedGraph.addEdge("LAX", "PHX", 370);
		undirectedGraph.addEdge("LAX", "LAS", 236);
		undirectedGraph.addEdge("LAX", "DEN", 862);
		undirectedGraph.addEdge("DEN", "LAS", 628);
		undirectedGraph.addEdge("MSP", "DEN", 680);
		undirectedGraph.addEdge("PHX", "DFW", 868);
		undirectedGraph.addEdge("LAS", "IAH", 1222);
		undirectedGraph.addEdge("LAS", "ORD", 1514);
		undirectedGraph.addEdge("ORD", "MSP", 334);
		undirectedGraph.addEdge("DFW", "IAH", 224);
		undirectedGraph.addEdge("IAH", "DCA", 1208);
		undirectedGraph.addEdge("DCA", "ORD", 334);
		
		//BREADTH
		System.out.println("Breadth First Traversal: ");
		QueueInterface<String> undirectedLine = undirectedGraph.getBreadthFirstTraversal("LAX");
		while(!undirectedLine.isEmpty()) {
			System.out.println(undirectedLine.dequeue());
		}
		
		//DEPTH
		System.out.println("Depth First Traversal: ");
		QueueInterface<String> undirectedLine2 = undirectedGraph.getDepthFirstTraversal("LAX");
		while(!undirectedLine2.isEmpty()) {
			System.out.println(undirectedLine2.dequeue());
		}
			
		//TOPOLOGICAL
		System.out.println("Topological Sort: ");
		try {
			StackInterface<String> undirectedStack = undirectedGraph.getTopologicalOrder();
			while(!undirectedStack.isEmpty()) {
				System.out.println(undirectedStack.pop());
			}
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		//CHEAPEST PATH
		System.out.println("Cheapest Path: ");
		StackInterface<String> undirectedPath = new LinkedStack<>();
		System.out.println(directedGraph.getCheapestPath("F", "M", undirectedPath));
		while(!undirectedPath.isEmpty())
			System.out.println(undirectedPath.pop());
	}
}