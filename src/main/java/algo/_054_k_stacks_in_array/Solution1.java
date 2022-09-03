package algo._054_k_stacks_in_array;

public class Solution1 {

  public static class MultiStack {
    int free;
    int size;
    int noOfStacks;
    int[] array;
    int[] next;
    int[] top;

    public MultiStack(int size, int noOfStacks) {
      this.size = size;
      this.noOfStacks = noOfStacks;
      this.array = new int[size];
      this.next = new int[size];
      this.top = new int[noOfStacks];
      this.free = 0;

      for (int i = 0; i < this.size; ++i) {
        this.next[i] = i + 1;
      }
      for (int i = 0; i < this.noOfStacks; ++i) {
        this.top[i] = -1;
      }
    }

    public void push(int val, int stack) {
      if (this.isFull()) {
        throw new RuntimeException("Stack is full");
      }
      int tmp = free;
      free = next[tmp];
      next[tmp] = top[stack];
      this.top[stack] = tmp;
      this.array[tmp] = val;
    }

    private boolean isFull() {
      return this.free == this.size;
    }

    public int pop(int stack) {
      if (this.isEmpty(stack)) {
        throw new RuntimeException("Stack is empty");
      }
      int popIndex = top[stack];
      top[stack] = next[popIndex];
      next[popIndex] = free;
      free = popIndex;
      return this.array[popIndex];
    }

    private boolean isEmpty(int stack) {
      if (top[stack] == -1) {
        return true;
      }
      return false;
    }

    public void print() {
      for (int s = 0; s < this.noOfStacks; ++s) {
        System.out.print("S");
        System.out.print(s);
        System.out.print(":");
        int j = top[s];
        while (j != -1) {
          System.out.print(this.array[j]);
          System.out.print(" -> ");
          j = this.next[j];
        }
        System.out.print("\n");
      }
    }
  }
}
