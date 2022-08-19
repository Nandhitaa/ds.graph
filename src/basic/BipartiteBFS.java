package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteBFS {

	private boolean checkBipartiteComponent(List<List<Integer>> adjList, int[] colour, int index) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		colour[index] = 0;

		while (!queue.isEmpty()) {
			int element = queue.poll();
			for (Integer adjElement : adjList.get(element)) {
				if (colour[adjElement] == -1) {
					queue.add(adjElement);
					colour[adjElement] = 1 - colour[element];
				}
				else if (colour[adjElement] == colour[element]) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean checkBipartite(List<List<Integer>> adjList) {
		int[] colour = new int[adjList.size()];
		Arrays.fill(colour, -1);
		
		for (int index = 1; index < adjList.size(); index++) {
			if (colour[index] == -1) {
				if (!checkBipartiteComponent(adjList, colour, index)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();

		int size = 8;

		for (int index = 0; index <= size; index++) {
			adjList.add(new ArrayList<Integer>());
		}

		adjList.get(1).add(2);
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(2).add(7);
		adjList.get(3).add(2);
		adjList.get(3).add(4);
		adjList.get(4).add(3);
		adjList.get(4).add(5);
		adjList.get(5).add(4);
		adjList.get(5).add(6);
		adjList.get(5).add(8);
		adjList.get(6).add(5);
		adjList.get(6).add(7);
		adjList.get(7).add(6);
		adjList.get(7).add(2);
		adjList.get(8).add(5);

		BipartiteBFS obj = new BipartiteBFS();
		boolean bipartite = obj.checkBipartite(adjList);
		System.out.println(bipartite);
	}
}
