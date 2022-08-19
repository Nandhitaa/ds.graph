package basic;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	private void dfsComponent(int element, List<List<Integer>> adjList, boolean visited[]) {
		System.out.print(element + "-");
		visited[element] = true;
		for (Integer adjElement : adjList.get(element)) {
			if (!visited[adjElement]) {
				dfsComponent(adjElement, adjList, visited);
			}
		}
	}

	private void dfs(List<List<Integer>> adjList) {
		boolean[] visited = new boolean[adjList.size()];
		for (int index = 1; index < adjList.size(); index++) {
			if (!visited[index]) {
				dfsComponent(index, adjList, visited);
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
		adjList.get(2).add(4);
		adjList.get(2).add(7);
		adjList.get(3).add(2);
		adjList.get(3).add(5);
		adjList.get(4).add(2);
		adjList.get(4).add(6);
		adjList.get(5).add(3);
		adjList.get(6).add(4);
		adjList.get(6).add(7);
		adjList.get(7).add(2);
		adjList.get(7).add(6);

		DFS obj = new DFS();
		obj.dfs(adjList);

	}
}
