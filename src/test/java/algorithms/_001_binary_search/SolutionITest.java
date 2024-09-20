package algorithms._001_binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionITest {

  PredecessorOfTargetI solution;

  @BeforeEach
  void setup() {
    solution = new PredecessorOfTargetI();
  }

  @Test
  void searchLeftmostDuplicate() {
    int[] nums = {1, 2, 2, 3, 4, 5, 5, 6};
    int target = 5;
    int expectedIndex = 5; // The leftmost index of 5 is at index 5
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchNoDuplicate() {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 3; // Target is present, not a duplicate
    int expectedIndex = 1; // The leftmost index of 3 is at index 2
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchDuplicateOnly() {
    int[] nums = {2, 2, 2, 2, 2};
    int target = 2; // All elements are duplicates of the target
    int expectedIndex = 0; // The leftmost index of 2 is at index 0
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchNotFound() {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 6;
    int expectedIndex = 4;
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchLastElement() {
    int[] nums = {1, 3, 5, 7, 9};
    int target = 9; // Target is the last element
    int expectedIndex = 3; // The predecessor of 9 is 7
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchDuplicatePredecessor() {
    int[] nums = {1, 3, 5, 5, 7, 9};
    int target = 6; // Target is between two 5's
    int expectedIndex = 3; // The predecessor of 6 is 5
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchAllElementsEqual() {
    int[] nums = {5, 5, 5, 5, 5};
    int target = 5; // Target is present, and all elements are equal
    int expectedIndex = 0; // The predecessor of 5 is 5 itself
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchNegativeNumbers() {
    int[] nums = {-10, -5, 0, 5, 10};
    int target = -1; // Target is between -5 and 0
    int expectedIndex = 1; // The predecessor of -1 is -5
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

  @Test
  void searchTargetLargerThanAllElements() {
    int[] nums = {1, 3, 5, 7, 9};
    int target = 10; // Target is larger than all elements in the array
    int expectedIndex = 4; // The predecessor of 10 is 9
    int result = solution.search(nums, target);
    assertEquals(expectedIndex, result);
  }

}

