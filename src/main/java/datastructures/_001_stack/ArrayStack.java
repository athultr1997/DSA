package datastructures._001_stack;

import java.util.ArrayList;


public class ArrayStack<T> implements Stack<T> {
  int top;
  int size;
  ArrayList<T> _array;

  public ArrayStack(int n) {
    this.top = -1;
    this.size = n;
    this._array = new ArrayList<T>(n);
    for (int i = 0; i < n; i++) {
      this._array.add(null);
    }
  }

  @Override
  public boolean isStackEmpty() {
    if (this.top == -1) {
      return true;
    }
    return false;
  }

  @Override
  public void push(T x)
      throws Exception {
    if (this.top == this.size - 1) {
      throw new Exception("Stack Overflow");
    }
    this.top++;
    this._array.set(this.top, x);
  }


  @Override
  public T pop()
      throws Exception {
    if (this.top == -1) {
      throw new Exception("Stack Underflow");
    }
    this.top--;
    return this._array.get(this.top + 1);
  }
}
