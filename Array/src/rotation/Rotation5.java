package rotation;
//Given a sorted and rotated array, find if there is a pair with a given sum
public class Rotation5 {
  public static void main(String[] args) {
    int a[] = {11,12, 15, 6, 8, 9, 10};
    int x = 27;
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
      low = 0;
      high = equalPoint;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] + a[mid + 1] ==x) {
          System.out.println(mid);
          System.out.println(mid +1);
          break;
        }
        if (a[low] + a[mid] <x) {
          low++;
        } else {
          high--;
        }
      }
    } else {
      low = equalPoint+1;
      high = a.length-1;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] + a[mid + 1] ==x) {
          System.out.println(mid);
          System.out.println(mid +1);
          break;
        }
        if (a[low] + a[mid] <x) {
          low++;
        } else {
          high--;
        }
      }
    }
  }
}
