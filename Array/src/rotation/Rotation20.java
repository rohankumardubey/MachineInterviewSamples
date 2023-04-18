package rotation;

public class Rotation20 {
  public static void main(String[] args) {
//    int[] a = {3, 6, 5, 1, 2 };
    int[] a ={1,2,3};
    boolean isAlreadySorted = true;
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1] < a[i]) {
        isAlreadySorted = false;
        break;
      }
    }
    if (isAlreadySorted) {
      System.out.println("FALSE");
    } else {
      int index  = -1;
      for (int i = 1; i < a.length; i++) {
        if(a[i-1] > a[i]) {
          index = i;
          break;
        }
      }
      if(index==-1) {
        System.out.println("FALSE");
      } else {
        boolean isSorted = true;
        for (int i = index+1; i < index+a.length; i++) {
          if(a[(i-1)%a.length] > a[i%a.length]) {
            isSorted = false;
            break;
          }
        }
        if(isSorted) {
          System.out.println("TRUE");
        } else {
          System.out.println("FALSE");
        }
      }
    }
  }
}
