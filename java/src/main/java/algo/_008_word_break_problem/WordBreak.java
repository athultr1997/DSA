package algo._008_word_break_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    WordBreak wordBreak = new WordBreak();
    int n = Integer.parseInt(in.readLine());
    String[] dictionary = in.readLine().split("\\s+");
    String word = in.readLine();
    System.out.println(wordBreak.canBreakDP(word, dictionary));
  }

  // 1. BRUTE FORCE SOLUTION
  // ##############################################################################################

  /**
   * Brute Force Solution based on the idea that search for prefix and if prefix present recursively
   * check if the suffix is present. TC - O(2^N), SC - O(lg(N) - since recursion so depth of tree?)
   * where N is the size of the word to be broken.
   *
   * @param word
   * @param dictionary
   * @return
   */
  private boolean canBreakBruteForce(String word, String[] dictionary) {
    Set<String> dicSet = new HashSet<>(dictionary.length, 1);
    for (int i = 0; i < dictionary.length; ++i) {
      dicSet.add(dictionary[i]);
    }
    return canBreakBruteForceHelper(word, dicSet);
  }

  private boolean canBreakBruteForceHelper(String word, Set<String> dicSet) {
    if (word.isEmpty()) {
      return true;
    }
    int n = word.length();
    for (int i = 0; i < n; ++i) {
      if (dicSet.contains(word.substring(0, i + 1))
          && canBreakBruteForceHelper(word.substring(i + 1, n), dicSet)) {
        return true;
      }
    }
    return false;
  }

  // ##############################################################################################

  // 2. DP SOLUTION
  // ##############################################################################################

  /**
   * dp[i] is true if the string till i is breakable else false. dp[0] is true since empty string is
   * breakable. TC - O(N), SC - O(N) where N is the size of the word to be broken.
   *
   * @param word
   * @param dictionary
   * @return
   */
  private boolean canBreakDP(String word, String[] dictionary) {
    int n = word.length();
    Set<String> dicSet = new HashSet<>(dictionary.length, 1);
    for (int i = 0; i < dictionary.length; ++i) {
      dicSet.add(dictionary[i]);
    }
    boolean dp[] = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; ++i) {
      for (int j = 0; j <= i; j++) {
        if (dp[j] && dicSet.contains(word.substring(j, i))) {
          dp[i] = true;
        }
      }
    }
    return dp[n];
  }

  /**
   * A trie can be used to make the operations like finding if the word exists in the dictionary
   * easier.
   *
   * @param word
   * @param dictionary
   * @return
   */
  private boolean canBreakDPAndTrie(String word, String[] dictionary) {
    return true;
  }

  /**
   * DP solution only finds whether it is possible to break or not. To find all the possible breaks
   * backtracking needs to be used. TC - O(2^N), SC - O(N^2)
   *
   * @param word
   * @param dictionary
   * @return
   */
  private List<List<String>> findAllPossibleBreaks(String word, String[] dictionary) {
    return null;
  }

}