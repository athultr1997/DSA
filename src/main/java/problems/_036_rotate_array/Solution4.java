package problems._036_rotate_array;

public class Solution4 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int gcd = gcd(n, k);
    int tmp;
    int current;
    int start;
    int j;
    for (int i = 0; i < gcd; ++i) {
      start = (i + k) % n;
      current = nums[i];
      j = start;
      do {
        tmp = nums[j];
        nums[j] = current;
        current = tmp;
        j = (j + k) % n;
      } while (j != start);
    }
  }

  int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }

}
