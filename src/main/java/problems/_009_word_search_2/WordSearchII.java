package problems._009_word_search_2;

import java.io.*;
import java.util.*;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once
 * in a word.
 */
public class WordSearchII {

  private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] boardString = in.readLine().split("\\s+");
    char[][] board = new char[boardString.length][boardString[0].length()];
    for (int i = 0; i < board.length; ++i) {
      char[] charArray = boardString[i].toCharArray();
      for (int j = 0; j < charArray.length; ++j) {
        board[i][j] = charArray[j];
      }
    }
    String[] words = in.readLine().split("\\s+");
    System.out.println();
    WordSearchII wordSearchII = new WordSearchII();
    System.out.println(wordSearchII.search(board, words));
  }
  
  public List<String> search(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    Set<String> wordsSet = new HashSet<>(words.length, 1);
    wordsSet.addAll(java.util.Arrays.asList(words));
    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        dfs(board, wordsSet, i, j, new StringBuilder(), result, n, m);
      }
    }
    return result;
  }

  private void dfs(char[][] board, Set<String> wordsSet, int i, int j, StringBuilder current,
      List<String> result, int n, int m) {
    if (j < 0 || i < 0 || i >= n || j >= m || board[i][j] == '{') {
      return;
    }
    char tmp = board[i][j];
    current.append(board[i][j]);
    board[i][j] = '{';
    if (wordsSet.contains(current.toString())) {
      result.add(current.toString());
    }
    for (int[] d : directions) {
      int nextI = i + d[0];
      int nextJ = j + d[1];
      dfs(board, wordsSet, nextI, nextJ, current, result, n, m);
    }
    current.deleteCharAt(current.length() - 1);
    board[i][j] = tmp;
  }
  
  public void searchTrie(char[][] board, String[] words) {

  }


}