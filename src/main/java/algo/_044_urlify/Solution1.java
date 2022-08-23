package algo._044_urlify;

import java.util.Stack;


public class Solution1 {
  public String urlify(String str, int trueLength) {
    Stack<Integer> stack = new Stack<>();
    char[] charArray = str.toCharArray();
    int n = charArray.length;
    for (int i = 0; i < trueLength; ++i) {
      if (charArray[i] == ' ') {
        stack.push(i);
      }
    }

    int end = trueLength;
    int gap = n - trueLength;
    while(!stack.isEmpty()) {
      int spaceIndex = stack.pop();
      for (int i = spaceIndex + 1; i < end; ++i) {
        charArray[i + gap] = charArray[i];
      }
      charArray[spaceIndex + gap] = '0';
      charArray[spaceIndex + gap - 1] = '2';
      charArray[spaceIndex + gap - 2] = '%';
      gap -= 2;
      end = spaceIndex;
    }
    return new String(charArray);
  }

}
