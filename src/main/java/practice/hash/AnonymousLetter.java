package practice.hash;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnonymousLetter {
  public static boolean canBeAnonymous(String text, String magazine) {
    Map<Character, Long> count =
        text.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (char m : magazine.toCharArray()) {
      if (count.containsKey(m)) {
        count.put(m, count.get(m) - 1);
        if (count.get(m) == 0) {
          count.remove(m);
        }
        if (count.isEmpty()) {
          break;
        }
      }
    }

    return count.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(canBeAnonymous("abbac", "abba"));
  }
}
