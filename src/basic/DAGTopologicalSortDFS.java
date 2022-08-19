package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DAGTopologicalSortDFS {

	private void sortComponent(List<List<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int element) {
		visited[element] = true;
		for (Integer adjElement : adjList.get(element)) {
			if (!visited[adjElement]) {
				sortComponent(adjList, stack, visited, adjElement);
			}
		}
		stack.push(element);
	}

	private void sort(List<List<Integer>> adjList, List<Integer> result) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[adjList.size()];

		for (int index = 0; index < adjList.size(); index++) {
			if (!visited[index]) {
				sortComponent(adjList, stack, visited, index);
			}
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

	}

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();

		int size = 6;

		for (int index = 0; index < size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(2).add(3);
		adjList.get(3).add(1);
		adjList.get(4).add(0);
		adjList.get(4).add(1);
		adjList.get(5).add(2);
		adjList.get(5).add(0);

		DAGTopologicalSortDFS obj = new DAGTopologicalSortDFS();
		List<Integer> result = new ArrayList<Integer>();
		obj.sort(adjList, result);
		System.out.println(result);

	}
}
