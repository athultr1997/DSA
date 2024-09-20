package problems._070_extra_characters_in_a_string;

public class SolutionII {

  public int minExtraChar(String s, String[] dictionary) {
    int n = s.length();
    // dp[n] is zero as the base case.
    int[] dp = new int[n + 1];

    TrieNode root = buildTrie(dictionary);
    int childIndex;
    for (int i = n - 1; i >= 0; --i) {
      TrieNode cur = root;
      dp[i] = Integer.MAX_VALUE;
      dp[i] = Math.min(dp[i], 1 + dp[i + 1]);

      for (int j = i; j < n; ++j) {
        childIndex = s.charAt(j) - 'a';
        cur = cur.children[childIndex];
        if (cur == null) {
          break;
        }
        if (cur.isTerminal) {
          dp[i] = Math.min(dp[i], dp[j + 1]);
        }
      }
    }

    return dp[0];
  }

  static private class TrieNode {

    public TrieNode[] children;
    public boolean isTerminal;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.isTerminal = false;
    }
  }

  private TrieNode buildTrie(String[] dictionary) {
    TrieNode root = new TrieNode();
    TrieNode cur;
    int childIndex;
    for (String word : dictionary) {
      cur = root;
      for (int i = 0; i < word.length(); ++i) {
        childIndex = word.charAt(i) - 'a';
        if (cur.children[childIndex] == null) {
          cur.children[childIndex] = new TrieNode();
        }
        cur = cur.children[childIndex];
      }
      cur.isTerminal = true;
    }
    return root;
  }

}
