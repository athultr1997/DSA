package problems._035_container_with_most_water;

public class Solution1 {

  public int maxArea(int[] height) {
    int n = height.length;
    int left = 0;
    int right = n - 1;
    int max = Integer.MIN_VALUE;
    int area;
    while (left < right) {
      if (height[left] < height[right]) {
        area = (right - left) * height[left];
        left++;
      } else {
        area = (right - left) * height[right];
        right--;
      }
      max = Math.max(max, area);
    }
    return max;
  }

}
