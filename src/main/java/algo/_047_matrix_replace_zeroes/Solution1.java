package algo._047_matrix_replace_zeroes;

import java.util.HashSet;
import java.util.Set;


public class Solution1 {
  public void setZeroes(int[][] matrix) {
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroCols = new HashSet<>();
    int m = matrix[0].length;
    int n = matrix.length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (matrix[i][j] == 0) {
          zeroRows.add(i);
          zeroCols.add(j);
        }
      }
    }

    for (int row : zeroRows) {
      for (int i = 0; i < m; ++i) {
        matrix[row][i] = 0;
      }
    }

    for (int col : zeroCols) {
      for (int j = 0; j < n; ++j) {
        matrix[j][col] = 0;
      }
    }
  }
}
