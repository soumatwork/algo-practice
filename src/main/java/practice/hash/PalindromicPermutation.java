package practice.hash;

import java.util.HashSet;
import java.util.Set;

public class PalindromicPermutation {
  public static boolean canBePalindrome(String a) {
    Set<Character> seen = new HashSet<>();
    for (char c : a.toCharArray()) {
      if (seen.contains(c)) {
        seen.remove(c);
      } else {
        seen.add(c);
      }
    }
    return seen.size() <= 1;
  }

  public static void main(String[] args) {
    System.out.println(canBePalindrome("edified"));
  }
}
