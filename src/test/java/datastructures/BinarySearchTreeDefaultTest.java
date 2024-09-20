package datastructures;

import datastructures._003_bst.BinarySearchTree;
import datastructures._003_bst.BinarySearchTreeDefault;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinarySearchTreeDefaultTest {

  BinarySearchTree<Integer> _binarySearchTree;

  @BeforeEach
  void setup() {
    _binarySearchTree = new BinarySearchTreeDefault<>();
    _binarySearchTree.insert(3);
    _binarySearchTree.insert(1);
    _binarySearchTree.insert(2);
    _binarySearchTree.insert(4);
    _binarySearchTree.insert(5);
    _binarySearchTree.insert(-15);
  }

  @Test
  void Insertion_Working() {
    _binarySearchTree.print();
  }

  @Test
  void Inorder_Working() {
    ArrayList<Integer> inorder = _binarySearchTree.inorder_traversal();
    System.out.print(inorder);
  }

  @Test
  void Search_Working() {
    boolean searchResult1 = _binarySearchTree.search(-15);
    boolean searchResult2 = _binarySearchTree.search(-35);
    assertTrue(searchResult1);
    assertFalse(searchResult2);
  }

  @Test
  void Maximum_Working() {
    Integer trueMax = 5;
    Integer testMax = _binarySearchTree.maximum();
    assertEquals(testMax, trueMax);
  }

  @Test
  void Minimum_Working() {
    Integer trueMax = -15;
    Integer testMax = _binarySearchTree.minimum();
    assertEquals(testMax, trueMax);
  }

  @Test
  void Successor_Working() {
    Integer trueSuccessor = 5;
    Integer testSuccessor = _binarySearchTree.successor(4);
    assertEquals(testSuccessor, trueSuccessor);
  }

  @Test
  void Predecessor_Working() {
    Integer truePredecessor = null;
    Integer testPredecessor = _binarySearchTree.predecessor(-15);
    assertEquals(truePredecessor, testPredecessor);
  }

}
