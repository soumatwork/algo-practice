package practice.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistanceFromEarth {
  static class Star implements Comparable<Star> {
    int x, y, z;

    public Star(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public double distance() {
      return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    @Override
    public int compareTo(Star o) {
      return this.distance() > o.distance() ? -1 : 1;
    }

    @Override
    public String toString() {
      return "Star{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
  }

  public static <T extends Comparable<T>> List<T> closestToEarth(Iterator<T> l, int k) {
    PriorityQueue<T> heap = new PriorityQueue<>();

    while (l.hasNext()) {
      heap.offer(l.next());
      if (heap.size() == k + 1) heap.poll();
    }

    return Stream.generate(heap::poll).limit(heap.size()).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(
        closestToEarth(
            Arrays.asList(new Star(0, 1, 1), new Star(0, 1, 0), new Star(0, 2, 1)).iterator(), 2));
  }
}
