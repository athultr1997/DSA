package algo._058_zero_one_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionIII {

  public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> bfsQueue = new LinkedList<>();
    int n = mat.length;
    int m = mat[0].length;
    int[][] distMat = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (mat[i][j] == 0) {
          bfsQueue.add(new int[]{i, j});
          distMat[i][j] = 0;
        } else {
          distMat[i][j] = Integer.MAX_VALUE;
        }

      }
    }

    int distance = 0;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    while (!bfsQueue.isEmpty()) {
      distance++;
      int size = bfsQueue.size();
      while (size > 0) {
        size--;
        int[] pos = bfsQueue.remove();
        int x = pos[0];
        int y = pos[1];
        for (int[] direction : directions) {
          int nextX = x + direction[0];
          int nextY = y + direction[1];
          if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
              && distMat[nextX][nextY] > distance) {
            distMat[nextX][nextY] = distance;
            bfsQueue.add(new int[]{nextX, nextY});
          }
        }
      }
    }
    return distMat;
  }

}
