package algorithms._003_sorting;

public class MergeSortTopDown {

  public int[] sort(int[] nums) {
    if (nums.length == 1) {
      return nums;
    }
    int n = nums.length;
    int leftSize = n / 2;
    int rightSize = n - n / 2;
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];

    System.arraycopy(nums, 0, left, 0, leftSize);

    if (n - leftSize >= 0) {
      System.arraycopy(nums, leftSize, right, 0, n - leftSize);
    }

    left = sort(left);
    right = sort(right);

    return merge(left, right);
  }

  private int[] merge(int[] left, int[] right) {
    int leftSize = left.length;
    int rightSize = right.length;
    int mergedSize = leftSize + rightSize;
    int[] merged = new int[mergedSize];

    int l = 0;
    int r = 0;
    int m = 0;
    for (; l < leftSize && r < rightSize; m++) {
      if (left[l] < right[r]) {
        merged[m] = left[l];
        l++;
      } else {
        merged[m] = right[r];
        r++;
      }
    }

    while (l < leftSize) {
      merged[m] = left[l];
      m++;
      l++;
    }
    while (r < rightSize) {
      merged[m] = right[r];
      m++;
      r++;
    }
    return merged;
  }


}
