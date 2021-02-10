package arc;

import java.time.Instant;

public class IdGenerator {
  public static boolean generate() {
    long now = Instant.now().toEpochMilli();
    long withEpoc = now << (64 - 41);
    System.out.println(Long.toBinaryString(now));
    withEpoc |= (1341 << (64 - 41 - 13));
    withEpoc |= (5003 % 1024);
    System.out.println(Long.toBinaryString(withEpoc));
    System.out.println(withEpoc);
    // long withEpoc |= withEpoc << (64-41);
    System.out.println(now);
    return false;
  }

  public static void main(String[] args) {
    System.out.println(generate());
  }
}
