package problems._054_k_stacks_in_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Solution1Test {

  private Solution1.MultiStack _multiStack;

  @BeforeEach
  public void setup() {
    _multiStack = new Solution1.MultiStack(9, 3);
  }

  @Test
  public void test() {
    _multiStack.push(1, 0);
    _multiStack.push(2, 1);
    _multiStack.push(3, 2);
    _multiStack.push(4, 2);
    _multiStack.push(5, 2);
    _multiStack.push(5, 1);
    _multiStack.push(10, 0);
    _multiStack.push(20, 1);
    _multiStack.push(21, 1);
    _multiStack.pop( 2);
    _multiStack.print();
  }
}
