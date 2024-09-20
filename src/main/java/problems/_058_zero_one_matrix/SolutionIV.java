package problems._058_zero_one_matrix;

public class SolutionIV {

  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] distMat = new int[n][m];

    // top-left to bottom-right from left to right
    int[][] directions = new int[][]{{-1, 0}, {0, -1}};
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (mat[i][j] == 0) {
          distMat[i][j] = 0;
        } else {
          // Need to check in line 24 by adding one to max value without causing overflow.
          distMat[i][j] = Integer.MAX_VALUE - 1;
        }
        for (int[] direction : directions) {
          int nextX = i + direction[0];
          int nextY = j + direction[1];
          if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
            distMat[i][j] = Math.min(distMat[i][j], 1 + distMat[nextX][nextY]);
          }
        }
      }
    }

    // bottom-right to top-left from right to left
    directions = new int[][]{{0, 1}, {1, 0}};
    for (int i = n - 1; i >= 0; --i) {
      for (int j = m - 1; j >= 0; --j) {
        for (int[] direction : directions) {
          int nextX = i + direction[0];
          int nextY = j + direction[1];
          if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
            distMat[i][j] = Math.min(distMat[i][j], 1 + distMat[nextX][nextY]);
          }
        }
      }
    }

    return distMat;
  }


}
