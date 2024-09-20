package algorithms._002_topological_sort;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortUsingKahnsAlgorithm {

  public List<Integer> topologicalSort(List<List<Integer>> adjList) {
    List<Integer> topSort = new LinkedList<>();
    Deque<Integer> startNodes = new LinkedList<>();
    int n = adjList.size();
    int[] indegree = new int[n];

    // Calculate the in-degrees of all nodes
    for (List<Integer> neighbours : adjList) {
      for (int nei : neighbours) {
        indegree[nei]++;
      }
    }

    // Find the nodes with zero in-degree
    for (int i = 0; i < n; ++i) {
      if (indegree[i] == 0) {
        startNodes.add(i);
        indegree[i] = -1;
      }
    }

    while (!startNodes.isEmpty()) {
      int curNode = startNodes.remove();
      topSort.add(curNode);
      List<Integer> neighbours = adjList.get(curNode);
      for (int nei : neighbours) {
        indegree[nei]--;
        if (indegree[nei] == 0) {
          startNodes.add(nei);
          indegree[nei] = -1;
        }
      }
    }

    for (int i = 0; i < n; ++i) {
      if (indegree[i] != -1) {
        return Collections.emptyList();
      }
    }

    return topSort;
  }

}
