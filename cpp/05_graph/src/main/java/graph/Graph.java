package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private int V;

  private List<List<List<Integer>>> adjList;

  public Graph(int V) {
    this.V = V;
    adjList = new ArrayList<>(V);
    for (int i = 0; i < V; ++i) {
      adjList.add(new ArrayList<>());
    }
  }

  public void insertEdge(int u, int v, int w) {
    if (u >= this.V || v >= this.V || u < 0 || v < 0) {
      return;
    }
    List<Integer> x = new ArrayList<>();
    x.add(v);
    x.add(w);
    adjList.get(u).add(x);
  }

  public void bellmanFoyd(int s) {
    if (s < 0 || s >= this.V) {
      return;
    }

  }

  public void print() {
    System.out.println("ADJACENCY LIST REPRESENTATION");
    System.out.println("##############################");
    for (int i = 0; i < this.V; ++i) {
      System.out.printf("%d | ", i);
      for (List<Integer> y : adjList.get(i)) {
        System.out.printf("(v = %d, w = %d) - ", y.get(0), y.get(1));
      }
      System.out.println("");
    }
  }

}
