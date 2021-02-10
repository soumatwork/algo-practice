package practice.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedEntries {

  public static int distance(List<String> paragraph) {
    int nearestDistance = Integer.MAX_VALUE;
    Map<String, Integer> latestIndexMap = new HashMap<>();

    for (int i = 0; i < paragraph.size(); i++) {
      String token = paragraph.get(i);
      if (latestIndexMap.containsKey(token)) {
        nearestDistance = Math.min(nearestDistance, i - latestIndexMap.get(token));
      }
      latestIndexMap.put(token, i);
    }

    return nearestDistance != Integer.MAX_VALUE ? nearestDistance : -1;
  }
}
