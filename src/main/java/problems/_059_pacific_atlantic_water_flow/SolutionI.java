package problems._059_pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionI {

  private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int n = heights.length;
    int m = heights[0].length;
    boolean[][] visitedPacific = new boolean[n][m];
    boolean[][] visitedAtlantic = new boolean[n][m];
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      bfs(i, 0, visitedPacific, heights);
      bfs(i, m - 1, visitedAtlantic, heights);
    }

    for (int j = 0; j < m; ++j) {
      bfs(0, j, visitedPacific, heights);
      bfs(n - 1, j, visitedAtlantic, heights);
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }

    return result;
  }

  void bfs(int i, int j, boolean[][] visited, int[][] heights) {
    Queue<int[]> bfsQueue = new LinkedList<>();
    bfsQueue.add(new int[]{i, j});
    visited[i][j] = true;
    int n = heights.length;
    int m = heights[0].length;
    int nextX;
    int nextY;
    while (!bfsQueue.isEmpty()) {
      int[] cur = bfsQueue.remove();
      i = cur[0];
      j = cur[1];
      for (int[] direction : directions) {
        nextX = i + direction[0];
        nextY = j + direction[1];
        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
            && !visited[nextX][nextY] && heights[i][j] <= heights[nextX][nextY]) {
          visited[nextX][nextY] = true;
          bfsQueue.add(new int[]{nextX, nextY});
        }
      }
    }
  }

}
