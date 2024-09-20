package algorithms._002_topological_sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortUsingDFS {

  private static final int WHITE = 0;
  private static final int GRAY = 1;
  private static final int BLACK = 2;

  public List<Integer> topologicalSort(List<List<Integer>> adjList) {
    int n = adjList.size();
    int[] colours = new int[n];
    List<Integer> topSortList = new LinkedList<>();
    boolean hasCycle;

    for (int i = 0; i < n; ++i) {
      if (colours[i] == WHITE) {
        hasCycle = dfsVisit(i, adjList, colours, topSortList);
        if (hasCycle) {
          return Collections.emptyList();
        }
      }
    }

    return topSortList;
  }

  private boolean dfsVisit(int cur, List<List<Integer>> adjList, int[] colours,
      List<Integer> topSortList) {
    colours[cur] = GRAY;
    for (int neighbour : adjList.get(cur)) {
      if (colours[neighbour] == WHITE) {
        dfsVisit(neighbour, adjList, colours, topSortList);
      } else if (colours[neighbour] == GRAY) {
        return true;
      }
    }
    colours[cur] = BLACK;
    topSortList.add(0, cur);
    return false;
  }

}
