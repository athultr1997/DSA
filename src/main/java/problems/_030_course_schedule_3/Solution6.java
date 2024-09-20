package problems._030_course_schedule_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution6 {

  public int scheduleCourse(int[][] courses) {
    int time = 0;
    Arrays.sort(courses, Comparator.comparingInt(x -> x[1]));
    Queue<Integer> q = new PriorityQueue<>((x1, x2) -> x2 - x1);
    for (int[] course : courses) {
      if (time + course[0] <= course[1]) {
        time += course[0];
        q.add(course[0]);
      } else if (!q.isEmpty() && q.peek() > course[0]) {
        int maxDuration = q.poll();
        time = time - (maxDuration - course[0]);
        q.add(course[0]);
      }
    }
    return q.size();
  }

}
