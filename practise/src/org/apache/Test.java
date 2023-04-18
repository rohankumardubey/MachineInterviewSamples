package org.apache;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
  public static void main (String[] args) throws Exception{
    int[] a = {1,2,3,7,5};
    int requiredSum=12;
    requiredSum(a, requiredSum);
  }

  static int minCost(int N)
  {
    // Initialize cost to 0
    int cost = 0;

    // going backwards until we
    // reach initial position
    while (N > 0) {

      if ((N & 1)>0) {
        cost += 1;
        N--;
      }
      else {
        int temp = N / 2;

        // if 2*X jump is
        // better than X+1
        if (temp > 1)
          cost += 1;
          // if X+1 jump is better
        else
          cost += temp;

        N /= 2;
      }
    }

    // return cost
    return cost;
  }

 static void requiredSum(int[] a, int requiredSum) {
    int currentSum = a[0];
    int start = 0;
   for (int i = 1; i <a.length ; i++) {
     currentSum+=a[i];
     if(currentSum>requiredSum) {
       currentSum-=a[start];
       start++;
     }
     if(requiredSum==currentSum) {
       System.out.println(start + "," + i);
     }
   }
 }
}
