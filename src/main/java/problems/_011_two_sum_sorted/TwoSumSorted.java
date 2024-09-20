package problems._011_two_sum_sorted;

public class TwoSumSorted {

  public int[] twoSum(int[] numbers, int target) {
    int n = numbers.length;
    int l = 0;
    int r = n - 1;
    int[] result = new int[2];
    while (l <= r) {
      if (numbers[l] + numbers[r] > target) {
        r--;
      } else if (numbers[l] + numbers[r] < target) {
        l++;
      } else {
        result[0] = l + 1;
        result[1] = r + 1;
        break;
      }
    }
    return result;
  }

}
