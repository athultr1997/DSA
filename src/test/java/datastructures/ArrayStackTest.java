package datastructures;

import datastructures._001_stack.ArrayStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ArrayStackTest {

  ArrayStack<Integer> _arrayStack;

  @BeforeEach
  void setup() {
    _arrayStack = new ArrayStack<Integer>(10);
  }

  @Test
  void Initially_Stack_Should_Be_Empty() {
    boolean testResult = _arrayStack.isStackEmpty();
    assertTrue(testResult);
  }

  @Test
  void After_Adding_One_Element_Size_Should_Be_One()
      throws Exception {
    int trueValue = 2;
    _arrayStack.push(trueValue);
    int testResult = _arrayStack.pop();
    boolean isEmptyTestResult = _arrayStack.isStackEmpty();

    assertEquals(trueValue, testResult);
    assertTrue(isEmptyTestResult);
  }
}
