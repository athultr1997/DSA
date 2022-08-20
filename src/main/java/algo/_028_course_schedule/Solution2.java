package algo._028_course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegrees = new int[numCourses];
    for (int[] edge : prerequisites) {
      indegrees[edge[0]]++;
    }
    Queue<Integer> q = new ArrayDeque<>();
    List<List<Integer>> graph = new ArrayList<>();
    int visitedCount = 0;
    for (int i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
        visitedCount++;
      }
      graph.add(new ArrayList<>());
    }
    for (int[] edge : prerequisites) {
      graph.get(edge[1]).add(edge[0]);
    }
    while (!q.isEmpty()) {
      int node = q.poll();
      for (Integer neighbour : graph.get(node)) {
        indegrees[neighbour]--;
        if (indegrees[neighbour] == 0) {
          q.add(neighbour);
          visitedCount++;
        }
      }
    }
    return visitedCount == numCourses;
  }

}
