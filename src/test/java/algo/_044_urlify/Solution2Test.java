package algo._044_urlify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution2Test {
  Solution2 _solution2;

  @BeforeEach
  void setup() {
    _solution2 = new Solution2();
  }

  @Test
  void test() {
    String input = "MR DD JJ KK PP        ";
    String expected = "MR%20DD%20JJ%20KK%20PP";
    String actual = _solution2.urlify(input, 14);
    Assertions.assertEquals(expected, actual);
  }
}
