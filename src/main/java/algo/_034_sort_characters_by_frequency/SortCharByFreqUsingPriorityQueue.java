package algo._034_sort_characters_by_frequency;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharByFreqUsingPriorityQueue {

  public String frequencySort(String s) {
    Map<Character, Integer> mapFromCharToFreq = new HashMap<>();
    for (char c : s.toCharArray()) {
      int freq = mapFromCharToFreq.getOrDefault(c, 0);
      mapFromCharToFreq.put(c, freq + 1);
    }
    Queue<Entry<Character, Integer>> pq = new PriorityQueue<>(new PQComparator());
    pq.addAll(mapFromCharToFreq.entrySet());
    StringBuilder result = new StringBuilder("");
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> m = pq.poll();
      int freq = m.getValue();
      char c = m.getKey();
      for (int i = 0; i < freq; ++i) {
        result.append(c);
      }
    }
    return result.toString();
  }

  private static class PQComparator implements Comparator<Entry<Character, Integer>> {

    public int compare(Map.Entry<Character, Integer> x1, Map.Entry<Character, Integer> x2) {
      return x2.getValue() - x1.getValue();
    }
  }

}
