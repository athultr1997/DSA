package algo._064_generate_all_permutations_repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionII {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> counter = new HashMap<>();
    int n = nums.length;
    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }
    List<Integer> cur = new ArrayList<>();
    permute(result, cur, counter, n);
    return result;
  }

  private void permute(List<List<Integer>> result, List<Integer> cur, Map<Integer, Integer> counter,
      int n) {
    if (cur.size() == n) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      int num = entry.getKey();
      int count = entry.getValue();
      if (count <= 0) {
        continue;
      }
      counter.put(num, count - 1);
      cur.add(num);
      permute(result, cur, counter, n);
      cur.remove(cur.size() - 1);
      counter.put(num, count);
    }
  }

}
