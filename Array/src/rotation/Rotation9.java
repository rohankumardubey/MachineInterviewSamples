package rotation;
//Find the Rotation Count in Rotated Sorted array
public class Rotation9 {
  public static void main(String[] args) {
    int a[] = {7, 9, 11, 12, 5};
    int low = 0;
    int high = a.length-1;
    int equPoint = -1;
    while(low<=high) {
      int mid = (low+high)/2;
      if(a[mid] > a[mid+1] && a[mid]>a[mid-1]) {
        equPoint = mid;
        break;
      }
      if(a[low]<a[mid]) {
        low++;
      } else {
        high--;
      }
    }
    if(equPoint == -1) {
      System.out.println(0);
    } else {
      System.out.println(equPoint+1);
    }
  }
}
