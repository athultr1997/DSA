package algo._030_course_schedule_3;

public class Solution1 {

  int max;

  public int scheduleCourse(int[][] courses) {
    max = Integer.MIN_VALUE;
    int n = courses.length;
    permutation(courses, 0, n);
    return max;
  }

  private void permutation(int[][] courses, int i, int n) {
    if (i == n) {
      int count = countCourses(courses, n);
      max = Math.max(max, count);
    }
    for (int j = i; j < n; ++j) {
      int[] tmp = courses[i];
      courses[i] = courses[j];
      courses[j] = tmp;
      permutation(courses, i + 1, n);
      courses[j] = courses[i];
      courses[i] = tmp;
    }
  }

  private int countCourses(int[][] courses, int n) {
    int nextEndTime = 0;
    int count = 0;
    for (int i = 0; i < n; ++i) {
      if (nextEndTime + courses[i][0] <= courses[i][1]) {
        count++;
        nextEndTime += courses[i][0];
      }
    }
    return count;
  }

}
