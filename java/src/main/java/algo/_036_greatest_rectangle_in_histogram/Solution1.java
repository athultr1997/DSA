package algo._036_greatest_rectangle_in_histogram;

public class Solution1 {

  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] leftBoundary = new int[n];
    int[] rightBoundary = new int[n];

    leftBoundary[0] = -1;
    for (int i = 1; i < n; ++i) {
      int j = i - 1;
      while (j >= 0 && heights[j] >= heights[i]) {
        j = leftBoundary[j];
      }
      leftBoundary[i] = j;
    }

    rightBoundary[n - 1] = n;
    for (int i = n - 2; i >= 0; --i) {
      int j = i + 1;
      while (j < n && heights[j] >= heights[i]) {
        j = rightBoundary[j];
      }
      rightBoundary[i] = j;
    }

    int maxArea = 0;
    int area;
    for (int i = 0; i < n; ++i) {
      area = heights[i] * (rightBoundary[i] - leftBoundary[i] - 1);
      maxArea = Math.max(area, maxArea);
    }
    return maxArea;
  }

}
