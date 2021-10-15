package graph;

import org.junit.jupiter.api.Test;

class GraphTest {

  @Test
  void insertEdge_ValidCase_PrintsProperly() {
    Graph g = new Graph(3);
    g.insertEdge(0, 1, 2);
    g.insertEdge(0, 2, 1);
    g.insertEdge(1, 2, 3);
    g.print();
  }

}
