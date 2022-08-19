package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.Pair;

public class DetectCycleBFS {

	private boolean detectCycle(List<List<Integer>> adjList) {
		boolean[] visited = new boolean[adjList.size()];
		for (int index = 1; index < adjList.size(); index++) {
			if (!visited[index]) {

				Queue<Pair> queue = new LinkedList<Pair>();
				queue.add(new Pair(index, -1));
				visited[index] = true;

				while (!queue.isEmpty()) {
					Pair pair = queue.poll();
					for (Integer adjElement : adjList.get(pair.data)) {
						if (visited[adjElement]) {
							if (adjElement != pair.parent) {
								return true;
							}
						}
						else {
							queue.add(new Pair(adjElement, pair.data));
							visited[adjElement] = true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<Integer>> adjList = new ArrayList<>();
		int size = 11;
		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(2);
		adjList.get(2).add(1);
		adjList.get(2).add(4);
		adjList.get(3).add(5);
		adjList.get(4).add(2);
		adjList.get(5).add(3);
		adjList.get(5).add(6);
		adjList.get(5).add(10);
		adjList.get(6).add(5);
		adjList.get(6).add(7);
		adjList.get(7).add(6);
		adjList.get(7).add(8);
		adjList.get(8).add(7);
		adjList.get(8).add(9);
		adjList.get(8).add(11);
		adjList.get(9).add(10);
		adjList.get(9).add(8);
		adjList.get(10).add(5);
		adjList.get(10).add(9);
		adjList.get(11).add(8);

		DetectCycleBFS obj = new DetectCycleBFS();
		boolean result = obj.detectCycle(adjList);
		System.out.println(result);

	}
}
