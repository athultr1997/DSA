package problems._044_string_compression;

public class Solution1 {
  public int compress(char[] chars) {
    int slow = 0;
    int fast = 0;
    int n = chars.length;
    int count = 1;
    while (fast < n) {
      if (fast + 1 < n && chars[fast] == chars[fast + 1]) {
        count++;
        fast++;
      } else {
        chars[slow] = chars[fast];
        slow++;
        if (count > 1) {
          char[] numArray = Integer.toString(count).toCharArray();
          for (int i = 0; i < numArray.length; ++i, ++slow) {
            chars[slow] = numArray[i];
          }
        }
        count = 1;
        fast++;
      }
    }
    return slow;
  }
}
