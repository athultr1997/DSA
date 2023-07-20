package algo._060_detonate_maxiumum_bombs;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionI {

  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    int[][] adjMatrix = new int[n][n];
    int maxDetonation = Integer.MIN_VALUE;
    int detonation = 0;

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i != j) {
          double x1 = bombs[i][0];
          double y1 = bombs[i][1];
          double r1 = bombs[i][2];
          double x2 = bombs[j][0];
          double y2 = bombs[j][1];
          double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
          if (r1 >= dist) {
            adjMatrix[i][j] = 1;
          }
        }
      }
    }

    for (int i = 0; i < n; ++i) {
      detonation = bfs(adjMatrix, i);
      if (detonation > maxDetonation) {
        maxDetonation = detonation;
      }
    }

    return maxDetonation;
  }

  public int bfs(int[][] adjMatrix, int i) {
    int detonation = 1;
    int n = adjMatrix.length;
    Queue<Integer> bfsQueue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    bfsQueue.add(i);
    visited[i] = true;
    while (!bfsQueue.isEmpty()) {
      int cur = bfsQueue.remove();
      for (int j = 0; j < n; ++j) {
        if (adjMatrix[cur][j] == 1 && !visited[j]) {
          bfsQueue.add(j);
          visited[j] = true;
          detonation++;
        }
      }
    }
    return detonation;
  }

}
