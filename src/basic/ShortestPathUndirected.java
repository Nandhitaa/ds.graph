package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirected {

	private void getDistances(List<List<Integer>> adjList, List<Integer> distances, int source) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		distances.set(source, 0);

		while (!queue.isEmpty()) {
			int currentElement = queue.poll();
			int distanceSoFar = distances.get(currentElement);
			for (Integer adjElement : adjList.get(currentElement)) {
				if (distances.get(adjElement) > 1 + distanceSoFar) {
					distances.set(adjElement, 1 + distanceSoFar);
					queue.add(adjElement);
				}
			}
		}

	}

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();

		int size = 9;

		for (int index = 0; index < size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(0).add(1);
		adjList.get(0).add(3);
		adjList.get(1).add(0);
		adjList.get(1).add(2);
		adjList.get(1).add(3);
		adjList.get(2).add(1);
		adjList.get(2).add(6);
		adjList.get(3).add(0);
		adjList.get(3).add(4);
		adjList.get(4).add(3);
		adjList.get(4).add(5);
		adjList.get(5).add(4);
		adjList.get(5).add(6);
		adjList.get(6).add(2);
		adjList.get(6).add(5);
		adjList.get(6).add(7);
		adjList.get(6).add(8);
		adjList.get(7).add(6);
		adjList.get(7).add(8);
		adjList.get(8).add(6);
		adjList.get(8).add(7);

		List<Integer> distances = new ArrayList<Integer>();
		for (int index = 0; index < size; index++) {
			distances.add(Integer.MAX_VALUE);
		}
		int source = 0;

		ShortestPathUndirected obj = new ShortestPathUndirected();
		obj.getDistances(adjList, distances, source);
		System.out.println(distances);

	}
}
