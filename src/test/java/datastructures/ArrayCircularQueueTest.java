package datastructures;

import datastructures._002_queue.ArrayCircularQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ArrayCircularQueueTest {

  ArrayCircularQueue<Integer> _arrayCircularQueue;

  @BeforeEach
  void setup() {
    _arrayCircularQueue = new ArrayCircularQueue<>(10);
  }

  @Test
  void Enqueue_Working() {
    _arrayCircularQueue.enqueue(10);
    _arrayCircularQueue.enqueue(20);
    boolean isEmptyTestResult = _arrayCircularQueue.isEmpty();
    int dequeuedFirstElement = _arrayCircularQueue.dequeue();
    int dequeuedSecondElement = _arrayCircularQueue.dequeue();

    assertFalse(isEmptyTestResult);
    assertEquals(dequeuedFirstElement, 10);
    assertEquals(dequeuedSecondElement, 20);
  }
}
