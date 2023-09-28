package problems._045_check_one_edit_away;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution2Test {
  private Solution2 _solution2;

  @BeforeEach
  void setup() {
    _solution2 = new Solution2();
  }

  @Test
  void test() {
    String str1 = "afb";
    String str2 = "ab";
    boolean actual = _solution2.checkIfOneEditAway(str1, str2);
    Assertions.assertTrue(actual);
  }
}
