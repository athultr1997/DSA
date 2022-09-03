package algo._055_min_stack;

import java.util.Stack;


public class MinStack {

  private long min;

  private Stack<Long> array;

  public MinStack() {
    array = new Stack();
    min = Long.MAX_VALUE;
  }

  public void push(int val) {
    if (array.size() == 0) {
      min = val;
      array.add(0l);
      return;
    }
    array.add(val - min);
    if (val < min) {
      min = val;
    }
    return;
  }

  public void pop() {
    long poppedElement = array.pop();
    if (poppedElement <= 0) {
      min = min - poppedElement;
    }
  }

  public int top() {
    long top = array.peek();
    if (top < 0) {
      return (int) (min);
    }
    return (int) (top + min);
  }

  public int getMin() {
    return (int) min;
  }
}
