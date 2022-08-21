package datastructures;

import datastructures._004_heap.DefaultHeap;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DefaultHeapTest {

  private DefaultHeap<Integer> _integerDefaultHeap;

  @BeforeEach
  void setup() {
    _integerDefaultHeap = new DefaultHeap<>(5);
  }

  @Test
  void Building_Heap_Working() {
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(15,19,9,21,20,15,120,30,22,24,25));
    _integerDefaultHeap.build_heap(arrayList);
    System.out.print(arrayList);
  }

  @Test
  void Heapsort_Working() {
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(15,19,9,21,20,15,120,30,22,24,25));
    _integerDefaultHeap.heapsort(arrayList);
    System.out.print(arrayList);
  }

}
