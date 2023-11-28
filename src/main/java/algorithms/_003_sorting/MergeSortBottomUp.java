package algorithms._003_sorting;

public class MergeSortBottomUp {

  public int[] sort(int[] nums) {
    int n = nums.length;
    // The two halves within a step will be merged.
    for (int step = 2; step < 2 * n; step += step) {
      for (int start = 0; start < n; start += step) {
        int end = Math.min(n - 1, start + step - 1) ;
        int mid = start + (step / 2) - 1;
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
          left[i] = nums[start + i];
        }

        for (int i = 0; i < rightSize; ++i) {
          right[i] = nums[mid + 1 + i];
        }

        int l = 0;
        int r = 0;
        int k = start;
        while (l < leftSize && r < rightSize) {
          if (left[l] <= right[r]) {
            nums[k] = left[l];
            ++l;
          } else {
            nums[k] = right[r];
            ++r;
          }
          ++k;
        }

        while (l < leftSize) {
          nums[k] = left[l];
          ++l;
          ++k;
        }

        while (r < rightSize) {
          nums[k] = right[r];
          ++r;
          ++k;
        }
      }
    }

    return nums;
  }

}
