package algo._044_urlify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution1Test {

  Solution1 _solution1;

  @BeforeEach
  void setup() {
    _solution1 = new Solution1();
  }

  @Test
  void test() {
    String input = "MR DD JJ KK PP        ";
    String expected = "MR%20DD%20JJ%20KK%20PP";
    String actual = _solution1.urlify(input, 14);
    Assertions.assertEquals(expected, actual);
  }

}
