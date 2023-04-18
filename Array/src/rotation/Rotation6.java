package rotation;
//Given a sorted and rotated array, print all pair with a given sum
public class Rotation6 {
  public static void main(String[] args) {
    int a[] = {10,11,12,13,15, 1, 2, 3, 4};
    int x = 23;
    int low = 0;
    int high = a.length - 1;
    int equalPoint = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
        equalPoint = mid;
      }
      if (a[low] < a[mid]) {
        low++;
      } else {
        high--;
      }
    }
    if(a[equalPoint] + a[equalPoint+1] < x) {
      for (int i = 0,j=equalPoint; i <=j ; ) {
          if(x == a[i] + a[j]) {
            System.out.println(a[i]);
            System.out.println(a[j]);
            i++;
            j--;
          } else if(x < a[i] + a[j]){
            j--;
          } else {
            i++;
          }
      }
    } else {
      for (int i = equalPoint+1,j=a.length-1; i <=j ; ) {
        if(x == a[i] + a[j]) {
          System.out.println(a[i]);
          System.out.println(a[j]);
          i++;
          j--;
        } else if(x < a[i] + a[j]){
          j--;
        } else {
          i++;
        }
      }
    }
  }
}
