package algo._045_check_one_edit_away;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution1Test {

  private Solution1 _solution1;

  @BeforeEach
  void setup() {
    _solution1 = new Solution1();
  }

  @Test
  void test() {
    String str1 = "ab";
    String str2 = "abc";
    boolean actual = _solution1.checkIfOneEditAway(str1, str2);
    Assertions.assertTrue(actual);
  }
}
