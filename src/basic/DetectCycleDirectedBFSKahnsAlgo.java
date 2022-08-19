package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleDirectedBFSKahnsAlgo {

	private boolean isCyclic(List<List<Integer>> adjList) {

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

		int count = 0;
		while (!queue.isEmpty()) {
			int element = queue.poll();
			count++;
			for (Integer adjElement : adjList.get(element)) {
				inDegrees[adjElement]--;
				if (inDegrees[adjElement] == 0) {
					queue.add(adjElement);
				}
			}
		}

		return count != adjList.size();

	}

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();

		int size = 4;

		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(2);
		adjList.get(2).add(3);
		adjList.get(3).add(4);
		adjList.get(4).add(2);

		DetectCycleDirectedBFSKahnsAlgo obj = new DetectCycleDirectedBFSKahnsAlgo();
		boolean cyclic = obj.isCyclic(adjList);
		System.out.println(cyclic);

	}
}
