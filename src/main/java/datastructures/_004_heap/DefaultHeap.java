package datastructures._004_heap;

import java.util.ArrayList;


public class DefaultHeap<T extends Comparable<T>> implements Heap<T> {
  private ArrayList<T> _array;
  private int size;

  public DefaultHeap(int size) {
    this.size = size;
    this._array = new ArrayList<>(this.size);
    for (int i = 0; i < this.size; ++i) {
      this._array.add(null);
    }
  }

  public void build_heap(ArrayList<T> array) {
    int n = array.size();
    int start = n / 2 - 1;
    for (int position = start; position >= 0; --position) {
      heapify(array, position, n);
    }
  }

  private void heapify(ArrayList<T> array, int position, int heap_size) {
    int n = heap_size;
    while (true) {
      int leftChild = 2 * position + 1;
      int rightChild = 2 * position + 2;

      int smallestChild = position;
      if (leftChild < n && array.get(leftChild).compareTo(array.get(smallestChild)) < 0) {
        smallestChild = leftChild;
      }
      if (rightChild < n && array.get(rightChild).compareTo(array.get(smallestChild)) < 0) {
        smallestChild = rightChild;
      }
      if (smallestChild == position) {
        return;
      }

      // Swap the smallest child with parent.
      T tmp = array.get(position);
      array.set(position, array.get(smallestChild));
      array.set(smallestChild, tmp);

      position = smallestChild;
    }
  }

  public void heapsort(ArrayList<T> array) {
    build_heap(array);
    int n = array.size();
    for (int i = n - 1; i > 0; --i) {
      T tmp = array.get(0);
      array.set(0, array.get(i));
      array.set(i, tmp);

      heapify(array, 0, i);
    }
  }

}
