package problems._031_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2Optimized {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<>();
    boolean[][] palindromes = new boolean[s.length()][s.length()];
    palindrome(result, current, 0, s, palindromes);
    return result;
  }

  private void palindrome(List<List<String>> result, List<String> current, int start, String s,
      boolean[][] palindromes) {
    if (start == s.length()) {
      result.add(new ArrayList<>(current));
      return;
    }
    for (int end = start; end < s.length(); ++end) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || palindromes[start + 1][end
          - 1])) {
        palindromes[start][end] = true;
        current.add(s.substring(start, end + 1));
        palindrome(result, current, end + 1, s, palindromes);
        current.remove(current.size() - 1);
      }
    }
  }

}
