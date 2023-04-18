package rotation;

//Search an element in a sorted and rotated array
public class Rotation4 {
  public static void main(String[] args) {
//    int a[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int a[] = {11,12, 1, 2, 3, 4, 5,6,7,8,9};
    System.out.println(serachIndex(a, 12));
  }

  private static int serachIndex(int a[], int d) {
    int low = 0;
    int high = a.length - 1;
    int equalPoint = 0;
    while (low <=high) {
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
    if(d >= a[0]) {
      low = 0;
      high = equalPoint;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] == d) {
          return mid;
        }
        if (a[mid] < a[mid + 1]) {
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
        if (a[mid] == d) {
          return mid;
        }
        if (a[mid] < a[mid + 1]) {
          low++;
        } else {
          high--;
        }
      }
    }
    return -1;
  }
}
