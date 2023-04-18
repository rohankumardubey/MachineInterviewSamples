package org.apache.dp;

public class DP1 {

  public static void main(String[] args) {
    int n = 8;
    int cost= 0;
    while (n > 0) {
      if (n % 2 != 0) {
        cost += 1;
        n--;
      } else {
        int temp = n/2;
        if(temp>1) {
          cost+=1;
        } else {
          cost+=temp;
        }
        n=n/2;
      }
    }
    System.out.println(cost);
  }
}
