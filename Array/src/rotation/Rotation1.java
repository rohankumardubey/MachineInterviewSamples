package rotation;
import java.util.Arrays;
//Program for array rotation
//Reversal algorithm for array rotation
public class Rotation1 {
  public static void main(String[] args) {
    int a[] = {1, 2, 3, 4, 5};
    sol2(a, 1);
    System.out.println(Arrays.toString(a));
  }


  private static void sol2(int a[] , int d) {
    int start = 0;
    int end = d-1;
    while(start<=end) {
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
    start = d;
    end = a.length -1;
    while(start<=end){
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
    start = 0;
    end = a.length-1;
    while(start<end) {
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
  }
  private static void sol1(int[] a , int d) {
    for(int i =0;i<d;i++) {
      int temp = a[0];
      for(int j=1;j<a.length;j++) {
        a[j-1] = a[j];
      }
      a[a.length-1] = temp;
    }
  }

  private static void sol3(int a[], int d) {
    final int gcd = gcd(a.length, d);
    int counter = 0;
    for (int i = 0; i < gcd; i++) {
      int temp = a[i];
      int j = i;
      while(true) {
        int k = j+d;
        if(k>a.length-1) {
          k = k-a.length;
        }
        if (k == i) {
          break;
        }
        a[j] = a[k];
        j=k;
        counter++;
        System.out.println(Arrays.toString(a));
      }
      a[j] = temp;
    }
    System.out.println(counter);
  }

  static int gcd(int a, int b)
  {
    if (a == b)
      return b;
    else if(a>b) {
     return gcd(a-b, b);
    } else {
      return gcd(a, b-a);
    }
  }

  private static boolean isPrime(int num, int num1) {
    if(num<2) {
      return false;
    }
    if(num1==1) {
      return true;
    }
    if(num%num1==0) {
      return false;
    }
    else {
      return isPrime(num, num-1);
    }
  }
}
