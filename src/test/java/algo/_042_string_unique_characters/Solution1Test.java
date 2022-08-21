package algo._042_string_unique_characters;

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
  void IsUniqueChars_UniqueCharString() {
    String str = "alk1234567890-`";
    boolean actual = _solution1.isUniqueChars(str);
    Assertions.assertTrue(actual);
  }

  @Test
  void IsUniqueChars_NonUniqueCharString() {
    String str = "alkaasdjhjkh21j3h12kj3';;l;lkal";
    boolean actual = _solution1.isUniqueChars(str);
    Assertions.assertFalse(actual);
  }

}
