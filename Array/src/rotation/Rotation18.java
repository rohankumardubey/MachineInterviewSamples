package rotation;

//Check if it is possible to sort the array after rotating it
//Given an array of size N, the task is to determine whether
// its possible to sort the array or not by just one shuffle.
// In one shuffle, we can shift some contiguous elements from the end of
// the array and place it in the front of the array.
public class Rotation18 {
  public static void main(String[] args) {
    int[] a = {2, 3, 1, 1};
    boolean isAlreadySorted = true;
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1] > a[i]) {
        isAlreadySorted = false;
      }
    }
    if (isAlreadySorted) {
      System.out.println("already sorted");
    } else {
      isAlreadySorted = true;
      int splitIndex = 0;
      for (int i = 1; i < a.length; i++) {
          if(a[i-1] >a[i]) {
            splitIndex = i;
            break;
          }
      }
      int lastElement =a[splitIndex];
      for (int i = splitIndex+1; i < splitIndex+a.length; i++) {
        if(lastElement> a[i%a.length]) {
            isAlreadySorted = false;
            break;
        }
        lastElement = a[i%a.length];
      }
    }
    System.out.println(isAlreadySorted);
  }
}
