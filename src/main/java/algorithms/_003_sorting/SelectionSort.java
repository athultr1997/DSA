package algorithms._003_sorting;

public class SelectionSort {

  public int[] sort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; ++i) {
      int minIndex = i;
      for (int j = i + 1; j < n; ++j) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int tmp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = tmp;
      }
    }
    return nums;
  }

}
