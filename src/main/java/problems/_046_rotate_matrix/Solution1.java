package problems._046_rotate_matrix;

public class Solution1 {
  public void rotate(int[][] matrix) {
    int n = matrix[0].length;
    int maxDepth = n / 2;
    for (int d = 0; d < maxDepth; ++d) {
      for (int i = d; i < n - 1 - d; ++i) {
        int tmp1 = matrix[i][n - 1 - d];
        matrix[i][n - 1 - d] = matrix[d][i];
        int tmp2 = matrix[n - 1 - d][n - 1 - i];
        matrix[n - 1 - d][n - 1 - i] = tmp1;
        int tmp3 = matrix[n - 1 - i][d];
        matrix[n - 1 - i][d] = tmp2;
        matrix[d][i] = tmp3;
      }
    }
  }
}
