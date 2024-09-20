package problems._036_rotate_array;

public class Solution2 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int start = 0;
    int countRotated = 0;
    int temp;
    int current = 0;
    int numToBeRotated = nums[0];

    while (countRotated < n) {
      do {
        temp = nums[(current + k) % n];
        nums[(current + k) % n] = numToBeRotated;
        countRotated++;
        numToBeRotated = temp;
        current = (current + k) % n;
      } while (start != current);
      start++;
      if (start >= n) {
        break;
      }
      current = start;
      numToBeRotated = nums[start];
    }
  }

}
