package rotation;

//Find the minimum element in a sorted and rotated array
public class Rotation12 {
  public static void main(String[] args) {
    int a[] = { 5, 6, 1, 2, 3, 4 };
    int low = 0;
    int high = a.length - 1;
    int mid = -1;
    while (low < high) {
      mid = (low + high) / 2;
      if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
        break;
      } else if (a[low] < a[mid]) {
        low++;
      } else {
        high--;
      }
    }
    if(mid!=-1) {
      System.out.println(a[0] < a[mid+1]?a[0]:a[mid+1]);
    }
  }
}
