package basic;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedDFS {

	private boolean isCyclicComponent(List<List<Integer>> adjList, boolean[] visited, boolean[] dirVisited, int element) {
		visited[element] = true;
		dirVisited[element] = true;

		for (Integer adjElement : adjList.get(element)) {
			if (dirVisited[adjElement]) {
				return true;
			}
			if (!visited[adjElement]) {
				if (isCyclicComponent(adjList, visited, dirVisited, adjElement)) {
					return true;
				}
			}
		}

		dirVisited[element] = false;
		return false;
	}

	private boolean isCyclicGraph(List<List<Integer>> adjList) {
		boolean[] visited = new boolean[adjList.size()];
		boolean[] dirVisited = new boolean[adjList.size()];

		for (int element = 1; element < adjList.size(); element++) {
			if (!visited[element]) {
				if (isCyclicComponent(adjList, visited, dirVisited, element)) {
					return true;
				}
				dirVisited[element] = false;
			}
		}

		return false;

	}

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();

		int size = 9;

		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(2);
		adjList.get(2).add(3);
		adjList.get(3).add(4);
		adjList.get(3).add(6);
		adjList.get(4).add(5);
		adjList.get(6).add(5);
		adjList.get(7).add(2);
		adjList.get(7).add(8);
		adjList.get(8).add(9);
		adjList.get(9).add(7);

		DetectCycleDirectedDFS obj = new DetectCycleDirectedDFS();
		boolean cyclic = obj.isCyclicGraph(adjList);
		System.out.println(cyclic);

	}
}
