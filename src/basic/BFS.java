package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private void bfs(List<List<Integer>> adjList) {

		boolean visited[] = new boolean[adjList.size()];

		for (int index = 1; index < adjList.size(); index++) {
			if (!visited[index]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(index);
				visited[index] = true;

				while (!queue.isEmpty()) {
					int element = queue.poll();
					System.out.print(element + "-");
					for (Integer adjIndex : adjList.get(element)) {
						if (!visited[adjIndex]) {
							queue.add(adjIndex);
							visited[adjIndex] = true;
						}
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> adjList = new ArrayList<>();
		int size = 7;
		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(2);
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(2).add(7);
		adjList.get(3).add(2);
		adjList.get(3).add(5);
		adjList.get(5).add(3);
		adjList.get(5).add(7);
		adjList.get(7).add(2);
		adjList.get(7).add(5);
		adjList.get(4).add(6);
		adjList.get(6).add(4);

		BFS obj = new BFS();
		obj.bfs(adjList);

	}
}
