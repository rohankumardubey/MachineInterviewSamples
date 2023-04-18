package arrangement;

import java.util.Arrays;
import java.util.Comparator;

public class Arrangement14 {
  public static void main(String[] args) {
    int[] a = {12,11,-13,-5,6,-7,5,-3,-6};
    Integer[] a1 = new Integer[a.length];
    for (int i = 0; i <a.length ; i++) {
      a1[i] = a[i];
    }
    Arrays.sort(a1, new ArrayComparator(a));
    for (int i = 0; i < a1.length; i++) {
      a[i] = a1[i];
    }
    System.out.println(Arrays.toString(a));
  }

  private static class ArrayComparator implements Comparator<Integer> {
    private int[] a;
    public ArrayComparator(int[] a) {
      this.a = a;
    }

    @Override public int compare(Integer o1, Integer o2) {
      if (o1 >= 0 && o2 < 0) {
        return 1;
      } else if (o1 < 0 && o2 >= 0) {
        return -1;
      } else if(o1.equals(o2)) {
        return 0;
      }else {
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==o1) {
              firstIndex = i;
              break;
            }
        }
        for (int i = 0; i < a.length; i++) {
          if(a[i]==o2) {
            secondIndex = i;
            break;
          }
        }
        return firstIndex-secondIndex;
      }
    }
  }
}
