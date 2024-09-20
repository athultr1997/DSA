package problems._070_extra_characters_in_a_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionI {

  public int minExtraChar(String s, String[] dictionary) {
    int n = s.length();
    // dp[n] is zero as the base case.
    int[] dp = new int[n + 1];

    Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

    for (int i = n - 1; i >= 0; --i) {
      dp[i] = Integer.MAX_VALUE;
      dp[i] = Math.min(dp[i], 1 + dp[i + 1]);

      for (int j = i; j < n; ++j) {
        if (dictionarySet.contains(s.substring(i, j + 1))) {
          dp[i] = Math.min(dp[i], dp[j + 1]);
        }
      }
    }

    return dp[0];
  }

}
