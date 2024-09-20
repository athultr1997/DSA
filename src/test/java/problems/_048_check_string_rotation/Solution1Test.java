package problems._048_check_string_rotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution1Test {

  private Solution1 _solution1;

  @BeforeEach
  public void setup() {
    _solution1 = new Solution1();
  }

  @Test
  public void Check_Correct_Detection() {
    String str1 = "waterbottle";
    String str2 = "rbottlewate";
    boolean actual = _solution1.checkRotation(str1, str2);
    Assertions.assertTrue(actual);
  }

}
