package algorithms._002_topological_sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopologicalSortUsingKahnsAlgorithmTest {

  TopologicalSortUsingKahnsAlgorithm solution;

  @BeforeEach
  void setup() {
    solution = new TopologicalSortUsingKahnsAlgorithm();
  }

  @Test
  void graphWithSelfEdgeCycle() {
    List<List<Integer>> graph = new ArrayList<>();
    graph.add(new ArrayList<>(List.of(1))); // Node 0 has an outgoing edge to Node 1
    graph.add(new ArrayList<>(List.of(2))); // Node 1 has an outgoing edge to Node 2
    graph.add(new ArrayList<>(List.of(3))); // Node 2 has an outgoing edge to Node 3
    graph.add(new ArrayList<>(List.of(3))); // Node 3 has an outgoing edge to Node 3
    graph.add(new ArrayList<>(List.of(4))); // Node 4 has an outgoing edge to Node 4
    graph.add(new ArrayList<>()); // Node 5 has no outgoing edges

    List<Integer> result = solution.topologicalSort(graph);
    assertTrue(result.isEmpty());
  }

  @Test
  void graphWithCycle() {
    List<List<Integer>> graph = new ArrayList<>();
    graph.add(new ArrayList<>(List.of(1)));
    graph.add(new ArrayList<>(List.of(2)));
    graph.add(new ArrayList<>(List.of(0)));

    List<Integer> result = solution.topologicalSort(graph);
    assertTrue(result.isEmpty());
  }

  @Test
  void directedAcyclicGraphSmall() {
    List<List<Integer>> graph = new ArrayList<>();
    graph.add(new ArrayList<>(List.of(1)));
    graph.add(new ArrayList<>(List.of(2)));
    graph.add(new ArrayList<>(List.of()));

    List<Integer> result = solution.topologicalSort(graph);

    List<Integer> expectedResult = List.of(0, 1, 2);

    assertEquals(expectedResult, result);
  }


}
