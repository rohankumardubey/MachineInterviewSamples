package rotation;

public class Rotation21 {
  public static void main(String[] args) {
//    int[] a = { 7, 7, 8, 8, 9, 1, 1, 4, 2, 2 };
    int[] a= {-9, -8, 4, 4, 5, 5, -1};
    int startIndex = 1;
    int endIndex = a.length;
    if(a[0]==a[a.length-1]) {
      startIndex++;
      endIndex--;
    }
    for (int i = startIndex; i <endIndex ; i++) {
      if(a[i-1]!=a[i]) {
        System.out.println(a[i-1]);
      } else {
        i++;
      }
    }
    if(a[0] != a[a.length-1] && a[a.length-1] !=a[a.length-2]) {
      System.out.println(a[a.length-1]);
    }
  }
}
