package problems._031_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  Boolean[][] palindromes;

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<>();
    palindromes = new Boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); ++i) {
      palindromes[i][i] = Boolean.TRUE;
    }
    dfs(result, current, 0, s);
    return result;
  }

  private void dfs(List<List<String>> result, List<String> current, int start, String s) {
    if (start == s.length()) {
      result.add(new ArrayList<>(current));
      return;
    }
    for (int end = start; end < s.length(); ++end) {
      if (isPalindrome(s, start, end)) {
        current.add(s.substring(start, end + 1));
        dfs(result, current, end + 1, s);
        current.remove(current.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int finish) {
    if (palindromes[start][finish] != null) {
      return palindromes[start][finish];
    }
    if (s.charAt(start) == s.charAt(finish) && (finish - start <= 2 || Boolean.TRUE
        .equals(palindromes[start + 1][finish - 1]))) {
      palindromes[start][finish] = Boolean.TRUE;
    } else {
      palindromes[start][finish] = Boolean.FALSE;
    }
    return palindromes[start][finish];
  }

}
