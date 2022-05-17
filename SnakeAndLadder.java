package GraphsDemo;

   // ----------------SNAKE AND LADDER GAME --------------------------
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SnakeAndLadder {

	HashMap<Integer, List<Integer>> H1 = new HashMap<>();

	public void addSource(int source) {
		H1.put(source, new ArrayList());
	}

	public void addEdge(int vertex1, int vertex2) {

		if (!H1.containsKey(vertex1)) {
			addSource(vertex1);
		}

		if (H1.containsKey(vertex1)) {
			H1.get(vertex1).add(vertex2);
		}
	}
     // This method is for displaying all key,listOf(values)attached to it
	
	void display() {
		for (int value : H1.keySet()) {
			System.out.print(value + " -->");
			for (int node : H1.get(value)) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		

		SnakeAndLadder obj = new SnakeAndLadder();

		int[] board = new int[45];
		board[2] = 13;
		board[5] = 2;
		board[9] = 18;
		board[17] = -13;
		board[20] = -14;
		board[24] = -8;
		board[25] = 10;
		board[32] = -2;
		board[34] = -22;

		
		for (int i = 0; i < 36; i++) {
			for (int dice = 1; dice <= 6; dice++) {
				int j = i + dice;

				j += board[j];

				obj.addEdge(i, j);

			}
		}

		obj.addEdge(36, 36);
		obj.bfs(0, 36);

	}

	// since all the edge cost is zero we can use Breadth for Search
	public void bfs(int source, int dest) {
		/*
		    1. Here at first we do not know the distance between  nodes
		    2. we Assume distance as Integer.MAX_VALUE(i..e infinity)
		    3. After the we are traversing every adjacent node and making 
		      distance as costOf(previousNode)+1;
		    4. In this way we are finding the cost to reach destination node  
		    
		 * 
		 */
		HashMap<Integer, Integer> distance = new HashMap<>();
		HashMap<Integer,Integer>  parent = new HashMap();

		
		for (int vertice : H1.keySet()) {
			distance.put(vertice, Integer.MAX_VALUE);
		}

		distance.put(source, 0);
		parent.put(source, 0);
		LinkedList<Integer> q = new LinkedList<>();
		q.add(source);
		
		

		while (!q.isEmpty()) {
			
			int presentNode = q.removeFirst();

			for (int node : H1.get(presentNode)) {
				if (node <= dest && distance.get(node) == Integer.MAX_VALUE) {
					
					distance.put(node, distance.get(presentNode) + 1);
					q.add(node);
					parent.put(node, presentNode);
				}
			}

		}

		System.out.println("Minimum Steps Required to Win a game from  " + source + " to " + dest + "  is  " + distance.get(dest));
		
         System.out.println("Flow as follows");
		
		while(dest!= source)
		{
			System.out.print(dest +" came from");
			System.out.println(" "+parent.get(dest));
			dest = parent.get(dest);
		}

	}

}
