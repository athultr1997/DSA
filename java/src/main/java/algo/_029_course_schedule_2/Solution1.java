package algo._029_course_schedule_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    int[] indegrees = new int[numCourses];
    Queue<Integer> q = new ArrayDeque<>();
    int[] topSort = new int[numCourses];
    int visitedNodes = 0;
    for (int i = 0; i < numCourses; ++i) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : prerequisites) {
      graph.get(edge[1]).add(edge[0]);
      indegrees[edge[0]]++;
    }
    for (int i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
      }
    }
    while (!q.isEmpty()) {
      int node = q.poll();
      topSort[visitedNodes] = node;
      visitedNodes++;
      for (int n : graph.get(node)) {
        indegrees[n]--;
        if (indegrees[n] == 0) {
          q.add(n);
        }
      }
    }
    return visitedNodes == numCourses ? topSort : new int[0];
  }

}
