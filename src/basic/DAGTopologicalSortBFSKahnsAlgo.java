package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAGTopologicalSortBFSKahnsAlgo {

	private void sort(List<List<Integer>> adjList, List<Integer> result) {

		int[] inDegrees = new int[adjList.size()];
		for (int index = 0; index < adjList.size(); index++) {
			for (Integer adjElement : adjList.get(index)) {
				inDegrees[adjElement]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int index = 0; index < inDegrees.length; index++) {
			if (inDegrees[index] == 0) {
				queue.add(index);
			}
		}

		while (!queue.isEmpty()) {
			int element = queue.poll();
			result.add(element);
			for (Integer adjElement : adjList.get(element)) {
				inDegrees[adjElement]--;
				if (inDegrees[adjElement] == 0) {
					queue.add(adjElement);
				}
			}
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
		adjList.get(5).add(0);
		adjList.get(5).add(2);

		DAGTopologicalSortBFSKahnsAlgo obj = new DAGTopologicalSortBFSKahnsAlgo();
		List<Integer> result = new ArrayList<Integer>();
		obj.sort(adjList, result);
		System.out.println(result);

	}
}
