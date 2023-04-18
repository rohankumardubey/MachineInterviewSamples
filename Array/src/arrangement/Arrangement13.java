package arrangement;

import java.util.Arrays;

public class Arrangement13 {
  public static void main(String[] args) {
//    int a[]   = {10, 11, 12};
//    int index[] = {1, 0, 2};
     int arr[] = new int[]{50, 40, 70, 60, 90};
     int index[] = new int[]{3,  0,  4,  1,  2};
    for (int i = 0; i < arr.length;i++) {
      if(index[i]!=i) {
        int temp = arr[index[i]];
        arr[index[i]] = arr[i];
        arr[i] = temp;
        temp= index[i];
        index[i] = index[index[i]];
        index[temp] = temp;
      }
    }
    // Fix all elements one by one
//    for (int i=0; i<arr.length; i++)
//    {
//      // While index[i] and arr[i] are not fixed
//      while (index[i] != i)
//      {
//        // Store values of the target (or correct)
//        // position before placing arr[i] there
//        int  oldTargetI  = index[index[i]];
//        char oldTargetE  = (char)arr[index[i]];
//
//        // Place arr[i] at its target (or correct)
//        // position. Also copy corrected index for
//        // new position
//        arr[index[i]] = arr[i];
//        index[index[i]] = index[i];
//
//        // Copy old target values to arr[i] and
//        // index[i]
//        index[i] = oldTargetI;
//        arr[i]   = oldTargetE;
//      }
//    }
    System.out.println(Arrays.toString(arr));

  }
}
