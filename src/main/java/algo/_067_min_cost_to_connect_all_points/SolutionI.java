package algo._067_min_cost_to_connect_all_points;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionI {

  public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
    boolean[] visited = new boolean[n];
    int minCost = 0;

    for (int i = 0; i < n; ++i) {
      int val = Integer.MAX_VALUE;
      if (i == 0) {
        val = 0;
      }
      Node node = new Node(val, i);
      minHeap.add(node);
    }
    int j = 0;
    // j reduces duplicate nodes in the heap. does not prevent it.
    while (!minHeap.isEmpty() && j < n) {
      Node node = minHeap.poll();
      if (visited[node.node]) {
        continue;
      }
      minCost += node.weight;
      j += 1;
      visited[node.node] = true;
      for (int i = 0; i < n; ++i) {
        if (!visited[i]) {
          int weight = distance(points[i], points[node.node]);
          // Not checking if the node i is already present in the heap
          minHeap.add(new Node(weight, i));
        }
      }
    }

    return minCost;
  }

  private class Node {

    public int weight;
    public int node;

    public Node(int weight, int node) {
      this.weight = weight;
      this.node = node;
    }
  }

  private class NodeComparator implements Comparator<Node> {

    public int compare(Node n1, Node n2) {
      return Integer.compare(n1.weight, n2.weight);
    }
  }

  private int distance(int[] cord1, int[] cord2) {
    return Math.abs(cord1[0] - cord2[0]) + Math.abs(cord1[1] - cord2[1]);
  }

}
