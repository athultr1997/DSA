package problems._042_string_unique_characters;

public class Solution1 {
  private static int TOTAL_ASCII_CHARACTERS = 256;
  public boolean isUniqueChars(String str) {
    boolean[] found = new boolean[TOTAL_ASCII_CHARACTERS];
    int n = str.length();
    if (n > TOTAL_ASCII_CHARACTERS) {
      return false;
    }
    for (int i = 0; i < n; ++i) {
      int val = str.charAt(i);
      if (found[val]) {
        return false;
      }
      found[val] = true;
    }
    return true;
  }
}
