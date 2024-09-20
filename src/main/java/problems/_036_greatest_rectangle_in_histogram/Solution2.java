package problems._036_greatest_rectangle_in_histogram;

import java.util.ArrayDeque;

public class Solution2 {

  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i <= n; ++i) {
      if (stack.isEmpty() || heights[stack.peekLast()] <= heights[i]) {
        stack.addLast(i);
      } else {
        while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
          int current = stack.removeLast();
          int right = i - 1;
          int left = stack.isEmpty() ? -1 : stack.peekLast();
          int area = heights[current] * (right - left);
          maxArea = Math.max(maxArea, area);
        }
        stack.addLast(i);
      }
    }

    int right = n - 1;
    while (!stack.isEmpty()) {
      int current = stack.removeLast();
      int left = stack.isEmpty() ? -1 : stack.peekLast();
      int area = heights[current] * (right - left);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

}
