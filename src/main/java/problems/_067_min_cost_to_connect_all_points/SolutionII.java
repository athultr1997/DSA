package problems._067_min_cost_to_connect_all_points;

public class SolutionII {

  public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    int minCost = 0;
    // minDist from each node to the MST
    int[] minDist = new int[n];

    minDist[0] = Integer.MAX_VALUE;
    for (int i = 1; i < n; ++i) {
      minDist[i] = distance(points[0], points[i]);
    }

    for (int i = 1; i < n; ++i) {
      // find min index and distance to MST.
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = 1; j < n; ++j) {
        if (minDist[j] != Integer.MAX_VALUE) {
          min = Math.min(min, minDist[j]);
          if (min == minDist[j]) {
            minIndex = j;
          }
        }
      }

      minCost += min;
      minDist[minIndex] = Integer.MAX_VALUE;

      for (int j = 0; j < n; ++j) {
        if (minDist[j] != Integer.MAX_VALUE && j != minIndex) {
          minDist[j] = Math.min(minDist[j], distance(points[j], points[minIndex]));
        }
      }
    }

    return minCost;
  }

  private int distance(int[] cord1, int[] cord2) {
    return Math.abs(cord1[0] - cord2[0]) + Math.abs(cord1[1] - cord2[1]);
  }

}
