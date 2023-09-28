package problems._044_string_compression;

public class Solution2 {
  public int compress(char[] chars) {
    int slow = 0;
    int fast = 0;
    int n = chars.length;
    int count;
    while (fast < n) {
      char currentChar = chars[fast];
      count = 0;
      while (fast < n && chars[fast] == currentChar) {
        count++;
        fast++;
      }
      chars[slow] = currentChar;
      slow++;
      if (count > 1) {
        for (char c : Integer.toString(count).toCharArray()) {
          chars[slow] = c;
          slow++;
        }
      }
    }
    return slow;
  }
}
