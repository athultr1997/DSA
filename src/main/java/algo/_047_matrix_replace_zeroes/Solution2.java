package algo._047_matrix_replace_zeroes;

public class Solution2 {
  public void setZeroes(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    // Flag to check if the first column should be deleleted or not.
    // matrix[0][0] will store if the first row should be deleted or not.
    // This can be used in the opposite way too.
    boolean isFirstColZero = false;

    for (int i = 0; i < n; ++i) {
      if (matrix[i][0] == 0) {
        isFirstColZero = true;
      }
      for (int j = 1; j < m; ++j) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // Do not mark the index row and col as zero since this will cause the entire matrix to be zero.
    // Hence, starting from 1.
    for (int i = 1; i < n; ++i) {
      for (int j = 1; j < m; ++j) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // Replaces the first row if needed.
    if (matrix[0][0] == 0) {
      for (int j = 1; j < m; ++j) {
        matrix[0][j] = 0;
      }
    }

    // Replace the first column if needed.
    if (isFirstColZero) {
      for (int i = 0; i < n; ++i) {
        matrix[i][0] = 0;
      }
    }
  }
}
