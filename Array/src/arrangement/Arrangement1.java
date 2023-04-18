package arrangement;

import java.util.Arrays;

//Rearrange an array such that arr[i] = i
//Given an array of elements of length N, ranging from 0 to N – 1.
// All elements may not be present in the array. If element is not present
// then there will be -1 present in the array. Rearrange the array such that A[i] = i and
// if i is not present, display -1 at that place.
public class Arrangement1 {
  public static void main(String[] args) {
    int[] a = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
        11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
    sol2(a);
//    Set<Integer> set = new HashSet<>();
//    for (int i = 0; i < a.length; i++) {
//      if(a[i]!=-1 && a[i]<a.length) {
//        set.add(a[i]);
//      }
//    }
//    Arrays.fill(a, -1);
//    final Iterator<Integer> iterator = set.iterator();
//    while(iterator.hasNext()) {
//      final Integer next = iterator.next();
//      a[next]= next;
//    }
    System.out.println(Arrays.toString(a));
  }

  private static void sol2(int[] a) {
    for (int i = 0; i < a.length; ) {
      if(a[i]>=0 && a[i]<a.length && a[i]!=i) {
        int temp = a[i];
        a[i] = a[a[i]];
        a[temp] = temp;
      }
      else {
        i++;
      }
    }
  }

}
