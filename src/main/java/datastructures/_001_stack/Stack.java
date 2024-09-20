package datastructures._001_stack;

public interface Stack<T> {
  boolean isStackEmpty();

  void push(T x)
      throws Exception;

  T pop()
      throws Exception;

}
