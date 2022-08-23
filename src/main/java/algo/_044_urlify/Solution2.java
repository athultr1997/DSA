package algo._044_urlify;

import java.util.Stack;


public class Solution2 {
  public String urlify(String str, int trueLength) {
    char[] charArray = str.toCharArray();
    int spaceCounts = 0;
    for (int i = 0; i < trueLength; ++i) {
      if (charArray[i] == ' ') {
        spaceCounts++;
      }
    }

    int fastPointer = trueLength + 2 * spaceCounts - 1;
    for (int slowPointer = trueLength - 1; slowPointer > 0; --slowPointer) {
      if (charArray[slowPointer] != ' ') {
        charArray[fastPointer] = charArray[slowPointer];
        fastPointer--;
      }
      else {
        charArray[fastPointer] = '0';
        charArray[fastPointer - 1] = '2';
        charArray[fastPointer - 2] = '%';
        fastPointer -= 3;
      }
    }
    return new String(charArray);
  }
}
