package problems._057_shortest_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

  private void dfs(Queue<int[]> bfsQueue, int[][] grid, int x, int y, int n) {
    if (grid[x][y] == 1) {
      grid[x][y] = 2;
      bfsQueue.add(new int[]{x, y});
    }
    for (int[] neighbour : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
      int nextX = neighbour[0];
      int nextY = neighbour[1];
      if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && grid[nextX][nextY] == 1) {
        dfs(bfsQueue, grid, neighbour[0], neighbour[1], n);
      }
    }
  }

  public int shortestBridge(int[][] grid) {
    // Find any island of the two islands.
    int n = grid.length;
    int startI = 0;
    int startJ = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          startI = i;
          startJ = j;
          i = n;
          j = n;
        }
      }
    }

    // Mark cells of the found island using DFS
    Queue<int[]> bfsQueue = new LinkedList();
    dfs(bfsQueue, grid, startI, startJ, n);

    // BFS from current island to the other island
    int distance = 0;
    Queue<int[]> nextBfsQueue = null;
    while (!bfsQueue.isEmpty()) {
      nextBfsQueue = new LinkedList();
      while (!bfsQueue.isEmpty()) {
        int[] pos = bfsQueue.remove();
        int x = pos[0];
        int y = pos[1];
        for (int[] neighbour : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
          int nextX = neighbour[0];
          int nextY = neighbour[1];
          if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
            if (grid[neighbour[0]][neighbour[1]] == 1) {
              return distance;
            } else if (grid[neighbour[0]][neighbour[1]] == 0) {
              nextBfsQueue.add(new int[]{neighbour[0], neighbour[1]});
              grid[nextX][nextY] = 2;
            }
          }
        }
      }
      distance++;
      bfsQueue = nextBfsQueue;
    }
    throw new RuntimeException("Solution not found");
  }

}
