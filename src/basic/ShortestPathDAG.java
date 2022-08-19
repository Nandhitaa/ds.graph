package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import ds.WeightPair;

public class ShortestPathDAG {

	private void topoSort(List<List<WeightPair>> adjList, Stack<Integer> stack, boolean[] visited, int element) {
		visited[element] = true;

		for (WeightPair adjElement : adjList.get(element)) {
			if (!visited[adjElement.data]) {
				topoSort(adjList, stack, visited, adjElement.data);
			}
		}

		stack.push(element);
	}

	private void getDistances(List<List<WeightPair>> adjList, int[] distances) {

		boolean[] visited = new boolean[adjList.size()];
		Stack<Integer> stack = new Stack<Integer>();

		for (int index = 0; index < adjList.size(); index++) {
			if (!visited[index]) {
				topoSort(adjList, stack, visited, index);
			}
		}

		while (!stack.isEmpty()) {
			int element = stack.pop();
			int distanceSoFar = distances[element];
			for (WeightPair adjElement : adjList.get(element)) {
				if (distances[adjElement.data] > distanceSoFar + adjElement.weight) {
					distances[adjElement.data] = distanceSoFar + adjElement.weight;
				}
			}
		}

	}

	public static void main(String[] args) {

		List<List<WeightPair>> adjList = new ArrayList<>();

		int size = 6;

		for (int index = 0; index < size; index++) {
			adjList.add(new ArrayList<WeightPair>());
		}

		adjList.get(0).add(new WeightPair(1, 2));
		adjList.get(0).add(new WeightPair(4, 1));
		adjList.get(1).add(new WeightPair(2, 3));
		adjList.get(2).add(new WeightPair(3, 6));
		adjList.get(4).add(new WeightPair(2, 2));
		adjList.get(4).add(new WeightPair(5, 4));
		adjList.get(5).add(new WeightPair(3, 1));

		ShortestPathDAG obj = new ShortestPathDAG();

		int[] distances = new int[adjList.size()];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;

		obj.getDistances(adjList, distances);

		for (int index = 0; index < distances.length; index++) {
			System.out.print(distances[index] + "-");
		}

	}
}
