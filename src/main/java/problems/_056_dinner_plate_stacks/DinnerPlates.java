package problems._056_dinner_plate_stacks;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;


public class DinnerPlates {
  // To store the capacity of a single stack.
  private int capacity;

  // The list of all the stacks, both open and closed.
  private List<Stack<Integer>> stacks;

  // The indices of open stacks.
  private TreeSet<Integer> openStacks;

  public DinnerPlates(int capacity) {
    this.capacity = capacity;
    this.stacks = new LinkedList<>();
    // TreeSet because need to keep the indices in sorted order and also need to remove and add indices.
    this.openStacks = new TreeSet<>();
  }

  // TC - O(N)
  public void push(int val) {
    if (!openStacks.isEmpty()) {
      int index = openStacks.first();
      Stack<Integer> stack = stacks.get(index);
      stack.push(val);
      if (stack.size() >= capacity) {
        openStacks.pollFirst();
      }
      return;
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(val);
    stacks.add(stack);
    if (stack.size() < capacity) {
      int size = stacks.size();
      openStacks.add(size - 1);
    }
  }

  // TC - O(N)
  public int pop() {
    int size = stacks.size();
    return popAtStack(size - 1);
  }

  // TC - O(N)
  public int popAtStack(int index) {
    int size = stacks.size();
    // index is less than zero when the size of the stacks is zero.
    if (index < 0 || index >= size || stacks.get(index).isEmpty()) {
      return -1;
    }
    int val = stacks.get(index).pop();
    openStacks.add(index);
    while (stacks.size() > 0 && stacks.get(stacks.size() - 1).isEmpty()) {
      stacks.remove(stacks.size() - 1);
      openStacks.pollLast();
    }
    return val;
  }
}
