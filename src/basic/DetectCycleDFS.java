package basic;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFS {

	private boolean isCycleComponent(List<List<Integer>> adjList, int element, int parent, boolean[] visited) {
		visited[element] = true;
		for (Integer adjElement : adjList.get(element)) {
			if (visited[adjElement]) {
				if (adjElement != parent) {
					return true;
				}
			}
			else {
				if (isCycleComponent(adjList, adjElement, element, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCycle(List<List<Integer>> adjList) {
		boolean[] visited = new boolean[adjList.size()];
		for (int index = 1; index < adjList.size(); index++) {
			if (!visited[index]) {
				if (isCycleComponent(adjList, index, -1, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<Integer>> adjList = new ArrayList<>();
		int size = 8;
		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(3);
		adjList.get(2).add(5);
		adjList.get(3).add(1);
		adjList.get(3).add(4);
		adjList.get(4).add(3);
		adjList.get(5).add(2);
		adjList.get(5).add(6);
		adjList.get(5).add(8);
		adjList.get(6).add(5);
		adjList.get(6).add(7);
		adjList.get(7).add(6);
		adjList.get(7).add(8);
		adjList.get(8).add(7);
		adjList.get(8).add(5);

		DetectCycleDFS obj = new DetectCycleDFS();
		boolean cycle = obj.isCycle(adjList);
		System.out.println(cycle);
	}
}
