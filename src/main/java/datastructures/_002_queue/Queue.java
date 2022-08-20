package datastructures._002_queue;

public interface Queue<T> {
  void enqueue(T t);
  T dequeue();
  boolean isEmpty();

  boolean isFull();
}
