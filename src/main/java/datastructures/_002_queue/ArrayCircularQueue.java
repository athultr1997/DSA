package datastructures._002_queue;

import java.util.ArrayList;


public class ArrayCircularQueue<T> implements Queue<T> {

  int size;
  int head;
  int tail;
  ArrayList<T> _array;

  public ArrayCircularQueue(int size) {
    this.size = size;
    this.head = -1;
    this.tail = -1;
    this._array = new ArrayList<T>(size);
    for (int i = 0; i < size; ++i) {
      this._array.add(null);
    }
  }

  @Override
  public void enqueue(T t) {
    if (this.isFull()) {
      throw new RuntimeException("Stack Overflow");
    }
    if (this.head == -1) {
      this.head = 0;
      this.tail = 0;
    } else {
      this.tail = (this.tail + 1) % this.size;
    }
    this._array.set(this.tail, t);
  }

  @Override
  public T dequeue() {
    T dequeuedElement = this._array.get(this.head);
    if (this.isEmpty()) {
      throw new RuntimeException("Stack Underflow");
    }
    if (this.head == this.tail) {
      this.head = -1;
      this.tail = -1;
    } else {
      this.head = (this.head + 1) % this.size;
    }
    return dequeuedElement;
  }

  @Override
  public boolean isEmpty() {
    return this.head == -1;
  }

  @Override
  public boolean isFull() {
    if ((this.tail + 1 == this.head)
        || ((this.head == 0) && (this.tail == this.size - 1))) {
      return true;
    }
    return false;
  }
}
