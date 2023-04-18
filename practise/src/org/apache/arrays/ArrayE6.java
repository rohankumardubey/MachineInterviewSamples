package org.apache.arrays;

//Maximum sum increasing subsequence
public class ArrayE6 {
  public static void main(String[] args) {
//    int a[] = { 1, 101, 2, 3, 100, 4, 5 };
    int a[]={10,3,4,5};
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      int prv = a[i];
      int sum = a[i];
      for (int j = i + 1; j < a.length; j++) {
        if(a[j] <prv) {
          if(sum>maxSum) {
            maxSum=sum;
          }
          sum-=prv;
        }
        sum+=a[j];
        prv = a[j];
      }
      if(maxSum<sum) {
        maxSum=sum;
      }
    }
    System.out.println(maxSum);
  }
}
