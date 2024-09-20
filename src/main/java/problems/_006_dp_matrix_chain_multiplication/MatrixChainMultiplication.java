package problems._006_dp_matrix_chain_multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution for the 'Matrix Chain Multiplication Problem'.
 */
public class MatrixChainMultiplication {

  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    MatrixChainMultiplication m = new MatrixChainMultiplication();
    int t = Integer.parseInt(in.readLine());
    for (int i = 0; i < t; ++i) {
      int N = Integer.parseInt(in.readLine());
      String input[] = in.readLine().trim().split("\\s+");
      int arr[] = new int[N];
      for (int j = 0; j < N; ++j) {
        arr[j] = Integer.parseInt(input[j]);
      }
      System.out.println(m.findMinimumMultiplicationOperations(arr, N));
    }
  }

  /**
   * Function used to find the minimum number of scalar mulitplications necessary to multiply a
   * chain of matrices using DP. TC - O(N^3). SC - O(N^2)
   */
  public int findMinimumMultiplicationOperations(int p[], int N) {

    // Handling invalid cases.
    if (N <= 0 || p == null || p.length == 0) {
      return 0;
    }

    // m[i][j] represents the minimum operations needed for multuplying matrices A[i],...,A[j].
    // The dimension of matrix Ai is p[i-1] * p[i].
    // The 0th row and 0th column are not used. They are added for ease of writing code.
    int m[][] = new int[N][N];

    // s[i][j] is used to store the position at which the chain was split for the chain A[i],...,A[j].
    // This is essential to actually print the parenthesized matrix chain.
    int s[][] = new int[N][N];

    // m[i][i] = 0 since the cost of multiplying a single matrix is zero.
    // This step is not necessary since arrays are zero by default. Adding for the sake of completeness.
    for (int i = 1; i < N; ++i) {
      m[i][i] = 0;
    }

    // l denotes the chain length of the matrices being multiplied.
    for (int l = 2; l < N; ++l) {
      // i denotes the starting matrix included in the current chain.
      for (int i = 1; i < N - l + 1; ++i) {
        // j denotes the ending matrix included in the current chain.
        int j = i + l - 1;
        m[i][j] = Integer.MAX_VALUE;
        // k denotes the that the matrix chain was split at A[k] and A[k+1]
        for (int k = i; k < j; ++k) {
          int ops = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (ops < m[i][j]) {
            m[i][j] = ops;
            s[i][j] = k;
          }
        }
      }
    }
    printDpTable(m);
    System.out.format("Optimized Parenthesis = %s\n", printOptimalParenthesis(s, 1, N - 1, N));
    return m[1][N - 1];
  }

  /**
   * Simple utility function to print the DP table for visualization.
   *
   * @param m
   */
  private void printDpTable(int m[][]) {
    System.out.println("##############################");
    System.out.println("The DP Table");
    System.out.println("##############################");
    for (int[] x : m) {
      for (int y : x) {
        System.out.format("%6d ", y);
      }
      System.out.println();
    }
    System.out.println("##############################");
  }

  /**
   * Function to actually print the parenthesized chain.
   *
   * @param s
   * @param i
   * @param j
   */
  private String printOptimalParenthesis(int s[][], int i, int j, int N) {
    if (i == j) {
      return "A" + i;
    }
    if (i >= N || j >= N) {
      return "";
    }
    return "(" + printOptimalParenthesis(s, i, s[i][j], N)
        + printOptimalParenthesis(s, s[i][j] + 1, j, N) + ")";
  }

}