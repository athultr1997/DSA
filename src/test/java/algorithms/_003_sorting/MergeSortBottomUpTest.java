package algorithms._003_sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortBottomUpTest {

  MergeSortBottomUp solution;

  @BeforeEach
  void setup() {
    solution = new MergeSortBottomUp();
  }

  @Test
  void smallArrayWithUnsortedElements() {
    int[] nums = new int[]{3, 1, 2};
    int[] actual = solution.sort(nums);

    int[] expected = new int[]{1, 2, 3};

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  void mediumArrayWithUnsortedElements() {
    int[] nums = new int[]{3, 1, 14, 15, 16, 2, 4, 5, 6, 7, 11, 12, 13, 8, 9, 10};
    int[] actual = solution.sort(nums);

    int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  void mediumArrayWithSortedElements() {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int[] actual = solution.sort(nums);

    int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    Assertions.assertArrayEquals(expected, actual);
  }
}
