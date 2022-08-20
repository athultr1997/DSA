package algo._007_dp_min_and_max_of_math_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathExpression {

  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    MathExpression m = new MathExpression();
    int t = Integer.parseInt(in.readLine());
    for (int i = 0; i < t; ++i) {
      int N = Integer.parseInt(in.readLine());
      char[] input = in.readLine().trim().toCharArray();
      int result[] = m.findMinAndMax(input, N);
      System.out.println("min = " + result[0]);
      System.out.println("max = " + result[1]);
    }
  }

  public int[] findMinAndMax(char input[], int N) {
    int n = N / 2;
    char operators[] = new char[n];
    char operands[] = new char[n];
    for (int i = 0, j = 0, k = 0; i < N; ++i) {
      if (i % 2 == 0) {
        operands[k] = input[i];
        ++k;
      } else {
        operators[j] = input[i];
        ++j;
      }
    }

    int minDP[][] = new int[n][n];
    int maxDP[][] = new int[n][n];

    return new int[]{1, 2};
  }


}